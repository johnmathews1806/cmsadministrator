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
import com.jm.cms.beans.CustomerDetails;
import com.jm.cms.beans.RegistrationDetails;
import com.jm.cms.entities.CmsAccount;
import com.jm.cms.entities.CmsUser;
import com.jm.cms.services.CustomerService;
import com.jm.cms.services.UserService;
import com.jm.cms.webservices.Country;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	@RequestMapping(value={"/secure/getCustomers/{name}"}, method=RequestMethod.GET, produces="application/json")
	//@PreAuthorize("hasPermission(#user,'VIEW_PROFILE')")
	public ResponseEntity<List<CmsAccount>> getCustomers(@PathVariable("name") String name) {
		String[] names = name.split(",");
		System.out.println(name);
		System.out.println(names.length);
		return new ResponseEntity<List<CmsAccount>>(customerService.searchCustomerByName(names[0].equals("")?null:names[0], names[1].equals("")?null:names[1], names[2].equals("")?null:names[2]),HttpStatus.OK);

	}
	
	@RequestMapping(value={"/custsetup/"}, method=RequestMethod.POST)	
	public ResponseEntity<Integer> createCustomer(@RequestBody CustomerDetails customerDetails) {				
		System.out.println("customer details: "+customerDetails);
		CmsAccount account = new CmsAccount();
		account.setFirstName(customerDetails.getFirstName().toUpperCase());		
		account.setMiddleName(customerDetails.getMiddleName());
		account.setLastName(customerDetails.getLastName());
		account.setDob(customerDetails.getDob());	
		System.out.println("amount : "+customerDetails.getBalance());
		account.setAccountBalance(customerDetails.getBalance());
		
		return new ResponseEntity<Integer>(customerService.createCustomer(account),HttpStatus.OK);

	}

}
