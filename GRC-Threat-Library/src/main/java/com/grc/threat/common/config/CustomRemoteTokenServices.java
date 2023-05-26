package com.grc.threat.common.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.grc.threat.common.dto.LoginUserDetails;
import com.grc.threat.common.utils.MapperUtils;

@Configuration
@Primary
public class CustomRemoteTokenServices extends RemoteTokenServices {

	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	@Value("${security.oauth2.resource.token-info-uri}")
	private String checkTokenEndpointUrl;

	protected final Log LOG = LogFactory.getLog(getClass());

	private RestOperations restTemplate;

	private String tokenName = "token";

	private Map<String, String> additionalParameters;

	private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

	public CustomRemoteTokenServices() {
		restTemplate = new RestTemplate();
		((RestTemplate) restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (response.getRawStatusCode() != 400) {
					super.handleError(response);
				}
			}
		});
	}

	@Override
	public void setRestTemplate(RestOperations restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setAdditionalParameters(Map<String, String> additionalParameters) {
		this.additionalParameters = additionalParameters;
	}

	@Override
	public OAuth2Authentication loadAuthentication(String accessToken) {
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		if (additionalParameters != null) {
			formData.setAll(additionalParameters);
		}
		formData.add(tokenName, accessToken);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));
		Map<String, Object> map = postForMap(checkTokenEndpointUrl, formData, headers);

		if (CollectionUtils.isEmpty(map)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("check_token returned empty");
			}
			throw new InvalidTokenException("Token is empty " + accessToken);
		}

		if (map.containsKey("error")) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("check_token returned error: " + map.get("error"));
			}
			throw new InvalidTokenException(map.get("error_description") + " " + accessToken); // error_description
																								// is added
		}

		if (map.containsKey("active") && !"true".equals(String.valueOf(map.get("active")))) {
			LOG.debug("check_token returned active attribute: " + map.get("active"));
			throw new InvalidTokenException(accessToken);
		}
		return getAuthentication(map);
	}

	@Override
	public OAuth2AccessToken readAccessToken(String accessToken) {
		throw new UnsupportedOperationException("Not supported: read access token");
	}

	private String getAuthorizationHeader(String clientId, String clientSecret) {
		String creds = String.format("%s:%s", clientId, clientSecret);
		return "Basic " + new String(Base64.getEncoder().encode(creds.getBytes(StandardCharsets.UTF_8)));
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> postForMap(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
		return restTemplate.exchange(path, HttpMethod.POST,
				new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
	}

	// setting login user details into OAuth2Authentication from the map
	private OAuth2Authentication getAuthentication(Map<String, Object> map) {
		OAuth2Authentication oauth = tokenConverter.extractAuthentication(map);
		oauth.setDetails(MapperUtils.mapToTargetClass(map, LoginUserDetails.class));
		return oauth;
	}

}
