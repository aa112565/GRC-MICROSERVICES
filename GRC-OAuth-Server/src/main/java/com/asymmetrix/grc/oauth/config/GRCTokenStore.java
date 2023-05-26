package com.asymmetrix.grc.oauth.config;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.asymmetrix.grc.oauth.common.utils.GRCConstants;

public class GRCTokenStore extends JdbcTokenStore {

	public GRCTokenStore(DataSource dataSource) {
		super(dataSource);
	}
	
	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		OAuth2AccessToken accessToken =  super.getAccessToken(authentication);
		if (Optional.ofNullable(accessToken).isPresent()) {
		accessToken.getAdditionalInformation().put(GRCConstants.IS_ALREADY_LOG_IN, Boolean.TRUE);
		}
		return accessToken;
	}

}