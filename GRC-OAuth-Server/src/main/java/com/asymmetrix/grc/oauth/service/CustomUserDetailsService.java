package com.asymmetrix.grc.oauth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.oauth.common.exception.GRCException;
import com.asymmetrix.grc.oauth.common.utils.GRCConstants;
import com.asymmetrix.grc.oauth.common.utils.GRCErrorConstants;
import com.asymmetrix.grc.oauth.common.utils.GRCUtils;
import com.asymmetrix.grc.oauth.dto.CustomUserDetails;
import com.asymmetrix.grc.oauth.entity.CnfgMenu;
import com.asymmetrix.grc.oauth.entity.CnfgPropertyDetails;
import com.asymmetrix.grc.oauth.entity.CnfgUser;
import com.asymmetrix.grc.oauth.repository.CnfgPropertyDetailsRepository;
import com.asymmetrix.grc.oauth.repository.GroupRepository;
import com.asymmetrix.grc.oauth.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Value("${grc.user.allowed.failedAttempts}")
	private int userAllowedAttempt;

	private static final String ERROR_USER_INACTIVE = "User Is Inactive Or Deleted";
	private static final String ERROR_USER_ACCOUNT_LOCKED = "User Account Is Locked";
	private static final String LOG_USER_INACTIVE = "User: {} Is Inactive Or Deleted";
	private static final String LOG_USER_ACCOUNT_LOCKED = "User: {} Is Account Is Locked";
	private static final String AUTH_TYPE = "auth.type";
	private static final String DB = "DB";
	private static final String ERROR_INVALID_GROUP = "User group is invalid or null";
	private static final String LOG_INVALID_GROUP = "User group :{} is invalid";
	

	private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Resource
	UserRepository userRepo;

	@Resource
	GroupRepository groupRepo;

	@Resource
	CnfgPropertyDetailsRepository extConfigRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<CnfgUser> cnfgUser = userRepo.findById(username);
		if (!cnfgUser.isPresent()) {
			throw new UsernameNotFoundException("User " + username + " not found in the GRC-DB");
		} else {
			if (isAccountActiveOrDeleted(cnfgUser.get().getAccountActive(), cnfgUser.get().getAccountDeleted())) {
				LOG.error(LOG_USER_INACTIVE, username);
				throw new UsernameNotFoundException(ERROR_USER_INACTIVE);
			}
			if (isAccountLocked(cnfgUser.get().getFailedAttempt())) {
				LOG.error(LOG_USER_ACCOUNT_LOCKED, username);
				throw new LockedException(ERROR_USER_ACCOUNT_LOCKED);
			}
		}
		if(ObjectUtils.isEmpty(cnfgUser.get().getCnfgUserGroup())){
			LOG.error(LOG_INVALID_GROUP, cnfgUser.get().getCnfgUserGroup());
			throw new GRCException(ERROR_INVALID_GROUP);
		}
		return new CustomUserDetails(cnfgUser.get(), getRole(cnfgUser.get().getCnfgUserGroup().getCnfgMenu()),
				isUserFirstTimeLogin(cnfgUser.get()), getUserSessionTimeOut(),
				getSubordinates(cnfgUser.get().getUserId()));
	}

	private List<SimpleGrantedAuthority> getRole(List<CnfgMenu> menuList) {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		for (CnfgMenu cnfgMenu : menuList) {
			roles.add(new SimpleGrantedAuthority(cnfgMenu.getRoleName()));
		}
		return roles;
	}

	private boolean isAccountLocked(int faliedAttemptFromDB) {
		return (userAllowedAttempt <= faliedAttemptFromDB);
	}

	private boolean isAccountActiveOrDeleted(Character accountActive, Character accountDeleted) {
		return (accountActive.equals('N') || accountDeleted.equals('Y'));
	}

	private boolean isUserFirstTimeLogin(CnfgUser cnfgUser) {
		if (!GRCConstants.SUPER_USER.equalsIgnoreCase(cnfgUser.getUserId())
				&& ObjectUtils.isEmpty(cnfgUser.getLastLogin())
				&& extConfigRepo.isExistsByCnfgKeyAndCnfgValue(AUTH_TYPE, DB)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private int getUserSessionTimeOut() {
		CnfgPropertyDetails cnfgDetails = extConfigRepo
				.findByCnfgKeyIgnoreCase(GRCConstants.PROP_USER_SESSION_TIMEOUT);
		GRCUtils.isValid(cnfgDetails, GRCErrorConstants.CNFG_KEY_NOT_FOUND.replace(GRCConstants.CURLY_BRACKETS,
				GRCConstants.PROP_USER_SESSION_TIMEOUT));
		return Integer.parseInt(cnfgDetails.getCnfgValue());
	}

	private String getSubordinates(String userId) {
		return GRCUtils.listToCSVString(userRepo.getAllUserByManagerId(userId));
	}

}
