package com.jm.cms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jm.cms.entities.CmsUser;
import com.jm.cms.services.UserService;

@Component
public class RestAuthenticationSuccessHandler 
extends SimpleUrlAuthenticationSuccessHandler {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response, Authentication authentication)
					throws ServletException, IOException {		
		System.out.println("Success Handler: "+ ((CmsUser)authentication.getPrincipal()).getFirstName());
		CmsUser user = (CmsUser)authentication.getPrincipal();
		System.out.println("Success Handler: "+ user);
		//user.setPassword(null);		
		SecurityUtils.sendResponse(response, HttpStatus.OK, user);
	}
}