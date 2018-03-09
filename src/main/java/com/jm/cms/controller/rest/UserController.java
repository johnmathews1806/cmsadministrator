package com.jm.cms.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.cms.beans.RegistrationDetails;
import com.jm.cms.entities.CmsUser;
import com.jm.cms.services.UserService;
import com.jm.cms.webservices.Country;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(value={"/secure/getUser/{loginId}"}, method=RequestMethod.GET, produces="application/json")
	//@PreAuthorize("hasPermission(#user,'VIEW_PROFILE')")
	public ResponseEntity<CmsUser> get(@PathVariable("loginId") String loginId) {

		return new ResponseEntity<CmsUser>(userService.getUserbyLoginId(loginId),HttpStatus.OK);

	}

	
	@RequestMapping(value={"/register/"}, method=RequestMethod.POST)	
	public ResponseEntity<Integer> register(@RequestBody RegistrationDetails registrationDetails) {				
		System.out.println("registration details: "+registrationDetails);
		CmsUser user = new CmsUser();
		user.setLoginId(registrationDetails.getEmailId().toUpperCase());
		user.setPassword(registrationDetails.getPassword());
		user.setFirstName(registrationDetails.getFirstName());
		user.setMiddleName(registrationDetails.getMiddleName());
		user.setLastName(registrationDetails.getLastName());
		user.setDob(registrationDetails.getDob());			
		
		return new ResponseEntity<Integer>(userService.createUser(user),HttpStatus.OK);

	}

}
