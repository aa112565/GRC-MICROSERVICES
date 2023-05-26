package com.asymmetrix.grc.oauth.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.asymmetrix.grc.oauth.common.exception.GRCException;
import com.asymmetrix.grc.oauth.common.utils.GRCConstants;
import com.asymmetrix.grc.oauth.dto.CustomUserDetails;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = null;
		if (!(authentication.getPrincipal() instanceof CustomUserDetails)) {
			throw new GRCException("Not a valid authentication user details instance");
		}
		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
		info = setDetails(user, accessToken);
		DefaultOAuth2AccessToken customToken = new DefaultOAuth2AccessToken(accessToken);
		customToken.setAdditionalInformation(info);
		return super.enhance(customToken, authentication);
	}

	private Map<String, Object> setDetails(CustomUserDetails user, OAuth2AccessToken accessToken) {
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
		info.put(GRCConstants.LOGIN_USER_NAME, user.getLoginUserName());
		info.put(GRCConstants.USER_NAME, user.getUsername()); //  userid from DB is maaped to user name field in JWT;
		info.put(GRCConstants.DEPARTMENT, user.getDepartment());
		info.put(GRCConstants.DEPARTMENT_TYPE, user.getDepartmentType());
		info.put(GRCConstants.EMAIL, user.getEmail());
		info.put(GRCConstants.PHONE, user.getPhone());
		info.put(GRCConstants.USER_LEVEL, user.getUserLevel());
		info.put(GRCConstants.MANAGER_ID, user.getManagerId());
		info.put(GRCConstants.SUB_ORDINATES, user.getSubordinates());
		info.put(GRCConstants.BRANCH_CODE, user.getBranchCode());
		info.put(GRCConstants.BRANCH_NAME, user.getBranchName());
		info.put(GRCConstants.FORCE_CHANGE_PASSWORD, user.isForceChangePassword());
		info.put(GRCConstants.SESSION_TIME_OUT, user.getUserSessionTimeOut());
		info.put(GRCConstants.LAST_LOGIN,user.getLastLogin());
		info.put(GRCConstants.HOME_PAGE, user.getHomePage());
		info.put(GRCConstants.IS_ALREADY_LOG_IN, Boolean.FALSE);
		return info;
	}
}
