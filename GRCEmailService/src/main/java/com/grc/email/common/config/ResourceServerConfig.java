package com.grc.email.common.config;

import java.util.Collections;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${cros.AllowedOrigins}")
	private String crosAllowedOrigin;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
		corsConfiguration.setAllowedOrigins(Collections.singletonList(crosAllowedOrigin));
		corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
		corsConfiguration.setAllowCredentials(true);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and().authorizeRequests()
				.antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources",
						"/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**")
				.permitAll().and().requestMatcher(new RequestHeaderRequestMatcher("Authorization")).authorizeRequests()
				.antMatchers("/**").authenticated().and().cors().configurationSource(request -> corsConfiguration).and()
				.headers().frameOptions().deny();
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

}
