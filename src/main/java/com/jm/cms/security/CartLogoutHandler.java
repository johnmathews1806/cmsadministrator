package com.jm.cms.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import com.jm.cms.entities.CmsUser;
import com.jm.cms.services.UserService;

@Component
public class CartLogoutHandler extends HttpStatusReturningLogoutSuccessHandler {


	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {


		
		 
		SecurityContextHolder.clearContext();

		SecurityContext securityContext = SecurityContextHolder.getContext();
		System.out.println("Principal after clearing: "+securityContext.getAuthentication());
		
		System.out.println("Logging out...");

		//response.setStatus(HttpStatus.OK.value());
		//response.getWriter().flush();


	}

}
