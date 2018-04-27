package com.jm.cms;

import javax.xml.ws.Endpoint;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jm.cms.services.CountryService;
import com.jm.cms.services.CustomerService;
import com.jm.cms.services.ProductService;
import com.jm.cms.webservices.Country;


public class TestServer {
    public static void main(String[] args) { 
    	System.out.println("running...");    	
        //Endpoint.publish("http://localhost:9090/ws/hello", new Hello());
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    	
    	CountryService countryService = context.getBean(CountryService.class);
    	System.out.println(countryService.getCountries());
    	
    	//ProductService productService = context.getBean(ProductService.class);
    	//System.out.println(productService.getProducts());
    	
    	//CustomerService customerService = context.getBean(CustomerService.class);
    	//System.out.println(customerService.searchCustomerByName("s", "s", "s"));
    	
    	ProductService productService = context.getBean(ProductService.class);
    	System.out.println(productService.getProducts());
    	

        System.out.println("terminated.");
         }  
}
