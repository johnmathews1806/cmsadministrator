package com.jm.cms.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


public class CustomPermissionEvaluator implements PermissionEvaluator{

	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {

		String desiredPermission = (String) permission;
		if(authentication.isAuthenticated()) { 	    
			for(GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				if(grantedAuthority.getAuthority().equalsIgnoreCase(desiredPermission)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		throw new RuntimeException("Not Implementing this.");
	}	
}