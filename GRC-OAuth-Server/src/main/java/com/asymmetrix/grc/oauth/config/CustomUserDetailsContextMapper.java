package com.asymmetrix.grc.oauth.config;

import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import com.asymmetrix.grc.oauth.service.CustomUserDetailsService;


public class CustomUserDetailsContextMapper extends LdapUserDetailsMapper{
	
	CustomUserDetailsService userService;
	
	 @Override
     public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
		 return userService.loadUserByUsername(username);
     }
	 
	 public CustomUserDetailsContextMapper(CustomUserDetailsService userService) {
		 super();
		 this.userService = userService;
	 }
	
}
