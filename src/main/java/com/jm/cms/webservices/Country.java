package com.jm.cms.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jm.cms.services.CountryService;

//@Service("country")
@WebService(serviceName="CountryService")
public class Country extends SpringBeanAutowiringSupport{
	
	//This cannot be an interface as JAXB cannot work with interfaces. Only applies to services invoked from  webservice.
	@Autowired
	private CountryService countryService;	
	
	/*
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
		System.out.println("------Country Service Set------");
	}	
	*/
	@WebMethod
    public List<String> getCountries() {	
		System.out.println("in getCountries WS - countryService: "+countryService);		
		//List<String> abc = new ArrayList<String>();
		//abc.add("SINGAPORE");
		//return abc;
        return countryService.getCountries();
    }
}
