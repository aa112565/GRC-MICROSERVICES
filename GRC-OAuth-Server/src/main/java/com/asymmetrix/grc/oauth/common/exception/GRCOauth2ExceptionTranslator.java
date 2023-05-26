package com.asymmetrix.grc.oauth.common.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

@Configuration
public class GRCOauth2ExceptionTranslator {

	private static final Logger LOG = LoggerFactory.getLogger(GRCOauth2ExceptionTranslator.class);
	
	@Bean
	public WebResponseExceptionTranslator<OAuth2Exception> oauth2ResponseExceptionTranslator() {
		return new DefaultWebResponseExceptionTranslator() {

			@Override
			public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
				LOG.error("Exception {}", e.getMessage());
				ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
				OAuth2Exception body = responseEntity.getBody();
				HttpStatus statusCode = responseEntity.getStatusCode();
				body.addAdditionalInformation("timestamp", LocalDateTime.now().toString());
				HttpHeaders headers = new HttpHeaders();
				headers.setAll(responseEntity.getHeaders().toSingleValueMap());
				//Since concurrent user logic has been moved to GRCTokenStore.java and 
				//we are not throwing any exception and just adding "isAleradyLoggedIn" as true in the JWT token payload. 
				//concurrent user comitId in jira - 916b90 (ERP-35)
				/*if (e instanceof GRCConcurrentUserException) {
					String[] errMsg = body.getMessage().split(GRCConstants.COLON);
					if (!ObjectUtils.isEmpty(errMsg) && errMsg.length >= 2) {
						body.addAdditionalInformation("accesscode", errMsg[1].trim());
						return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(body);
					}
				}*/
				return new ResponseEntity<>(body, headers, statusCode);
			}
		};
	}

}
