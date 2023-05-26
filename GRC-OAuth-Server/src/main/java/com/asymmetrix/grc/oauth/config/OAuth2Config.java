package com.asymmetrix.grc.oauth.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.asymmetrix.grc.oauth.service.CustomUserDetailsService;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	@Value("${config.oauth2.clientid}")
	private String clientid;
	@Value("${config.oauth2.clientSecret}")
	private String clientSecret;
	@Value("${config.oauth2.privatekey}")
	private String privatekey;
	@Value("${config.oauth2.publickey}")
	private String publickey;
	@Value("${config.oauth2.accessTokenValidity}")
	private int accessTokenValidity;
	@Value("${config.oauth2.refreshTokenValidity}")
	private int refreshTokenValidity;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
    private TokenStore tokenStore;
	
	@Resource
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private WebResponseExceptionTranslator<OAuth2Exception> oauth2ResponseExceptionTranslator;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientid).secret(passwordEncoder.encode(clientSecret)).scopes("read","write")
		.authorizedGrantTypes("password","refresh_token")
		.accessTokenValiditySeconds(accessTokenValidity)
		.refreshTokenValiditySeconds(refreshTokenValidity);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.userDetailsService(customUserDetailsService)
		.reuseRefreshTokens(false)
		.tokenStore(tokenStore)
		.exceptionTranslator(oauth2ResponseExceptionTranslator)
		.accessTokenConverter(tokenEnhancer());
	}
	

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter tokenConverter=new CustomTokenEnhancer();
		tokenConverter.setSigningKey(privatekey);
		tokenConverter.setVerifierKey(publickey);
		return tokenConverter;
	}
	
}
