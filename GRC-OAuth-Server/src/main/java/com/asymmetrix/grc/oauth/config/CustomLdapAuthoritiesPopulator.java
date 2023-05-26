package com.asymmetrix.grc.oauth.config;

import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import com.asymmetrix.grc.oauth.service.CustomUserDetailsService;

public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
	
	CustomUserDetailsService userService;
	
       @Override
       public Collection<? extends GrantedAuthority> getGrantedAuthorities(
                       DirContextOperations userData, String username) {
    	  UserDetails user = userService.loadUserByUsername(username);
    	  return user.getAuthorities();
       }
       
    public CustomLdapAuthoritiesPopulator (CustomUserDetailsService userService) {
    	super();
    	this.userService = userService;
    }
     
}