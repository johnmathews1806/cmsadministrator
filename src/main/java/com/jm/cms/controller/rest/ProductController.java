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
import com.jm.cms.entities.CmsProduct;
import com.jm.cms.entities.CmsUser;
import com.jm.cms.services.CustomerService;
import com.jm.cms.services.ProductService;
import com.jm.cms.services.UserService;
import com.jm.cms.webservices.Country;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@RequestMapping(value={"/secure/getProducts/{name}"}, method=RequestMethod.GET, produces="application/json")
	//@PreAuthorize("hasPermission(#user,'VIEW_PROFILE')")
	public ResponseEntity<List<CmsProduct>> getProducts(@PathVariable("name") String name) {
		String[] names = name.split(",");
		System.out.println(name);
		System.out.println(names.length);
		return new ResponseEntity<List<CmsProduct>>(productService.getProducts(),HttpStatus.OK);

	}	
	

}
