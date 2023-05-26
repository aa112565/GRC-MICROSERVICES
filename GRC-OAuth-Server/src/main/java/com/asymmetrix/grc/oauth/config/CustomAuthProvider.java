package com.asymmetrix.grc.oauth.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.asymmetrix.grc.oauth.encoder.CustomPasswordEnconder;
import com.asymmetrix.grc.oauth.entity.CnfgPropertyDetails;
import com.asymmetrix.grc.oauth.repository.CnfgPropertyDetailsRepository;
import com.asymmetrix.grc.oauth.service.CustomUserDetailsService;

@Configuration
public class CustomAuthProvider implements AuthenticationProvider {

	private static final String SUPER_USER = "SuperUser";
	private static final String LDAP_SEARCH_FILTER = "ldap.base";
	private static final String LDAP_URL_KEY = "ldap.urls";
	private static final String LDAP_DOMAIN_KEY = "ldap.domain";
	private static final String LDAP = "LDAP";
	private static final String AUTH_TYPE = "auth.type";
	private static final String CUSTOM_LDAP_PROVIDER_BEAN_NAME = "customLdapAuthProviderBean";
	private static final String LDAP_CONFIG_PROPERTIES_MISSING = "ldapUrl or ldapDomain is missing";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthProvider.class);
	
	@Resource
    private GenericWebApplicationContext context;
	
	@Resource
	CustomUserDetailsService customUserDetailsService;
	
	@Resource
	CnfgPropertyDetailsRepository extConfigRepo;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		if (isLdapAuthConfigured() && !SUPER_USER.equalsIgnoreCase(authentication.getName())) {
			LOGGER.info("Ldap Based authentication");
			return ldapAuthProvider().authenticate(authentication);
		} else {
			LOGGER.info("DB Based authentication");
			return dbAuthProvider().authenticate(authentication);
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	
	private boolean isLdapAuthConfigured() {
		CnfgPropertyDetails cnfg = extConfigRepo.findByCnfgKeyIgnoreCase(AUTH_TYPE);
		return !ObjectUtils.isEmpty(cnfg) && LDAP.equalsIgnoreCase(cnfg.getCnfgValue());
	}

	public LdapAuthenticationProvider ldapAuthProvider() {
		if(context.containsBean(CUSTOM_LDAP_PROVIDER_BEAN_NAME)){
			return (LdapAuthenticationProvider) context.getBean(CUSTOM_LDAP_PROVIDER_BEAN_NAME);
		}
		Map<String, String> ldapPropMap = getLdapPropFromDBAsMap();
		BindAuthenticator bindAuthenticator = getBindAuthenticator(ldapPropMap.get(LDAP_URL_KEY), ldapPropMap.get(LDAP_DOMAIN_KEY), ldapPropMap.get(LDAP_SEARCH_FILTER));
		LdapAuthenticationProvider ldapAuthProvider = new LdapAuthenticationProvider(bindAuthenticator,
				new CustomLdapAuthoritiesPopulator(customUserDetailsService));
		ldapAuthProvider.setUserDetailsContextMapper(new CustomUserDetailsContextMapper(customUserDetailsService));
		context.registerBean(CUSTOM_LDAP_PROVIDER_BEAN_NAME, LdapAuthenticationProvider.class, () -> ldapAuthProvider);
		return registerAndGetBean();
	}
	
	private LdapAuthenticationProvider registerAndGetBean() {
		return (LdapAuthenticationProvider) context.getBean(CUSTOM_LDAP_PROVIDER_BEAN_NAME);
	}
	
	private LdapContextSource getLdapContextSource(String ldapUrl) {
		LdapContextSource contextSource = new DefaultSpringSecurityContextSource(ldapUrl);
		contextSource.afterPropertiesSet();
		return contextSource;
	}
	
	private BindAuthenticator getBindAuthenticator(String ldapUrl, String ldapDomain, String ldapSearchBase){
		LdapContextSource contextSource = getLdapContextSource(ldapUrl);
		BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource);
		bindAuthenticator.setUserSearch(new FilterBasedLdapUserSearch(ldapDomain,
				ldapSearchBase, contextSource));
		return bindAuthenticator;
	}
	
	private Map<String, String> getLdapPropFromDBAsMap() {
		List<CnfgPropertyDetails> ldapUrlObj = extConfigRepo.findByCnfgNameIgnoreCase(LDAP);
		return validateAndGetLdapPropAsMap(ldapUrlObj);
	}
	
	private Map<String, String> validateAndGetLdapPropAsMap(List<CnfgPropertyDetails> ldapObjList) {
		Map<String, String> ldapPropMap = new HashMap<>();
		ldapObjList.forEach(ldapObj -> {
			if (ObjectUtils.isEmpty(ldapObj) || ObjectUtils.isEmpty(ldapObj.getCnfgValue())) {
				throw new IllegalArgumentException(LDAP_CONFIG_PROPERTIES_MISSING);
			} else {
				ldapPropMap.put(ldapObj.getCnfgKey(), ldapObj.getCnfgValue());
			}
		});
		return ldapPropMap;
	}
	
	@Bean
	public DaoAuthenticationProvider dbAuthProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new CustomPasswordEnconder();
	}
	
}
