package com.jm.cms.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jm.cms.entities.CmsProduct;
import com.jm.cms.services.CountryService;
import com.jm.cms.services.ProductService;

//@Service("product")
@WebService(serviceName="ProductService")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class Product extends SpringBeanAutowiringSupport{
	
	//This cannot be an interface as JAXB cannot work with interfaces. Only applies to services invoked from  webservice.
	@Autowired
	private ProductService productService;	
	
	
	@WebMethod
    public List<CmsProduct> getProducts() {	
		System.out.println("in getProducts WS - productService: "+productService);
        return productService.getProducts();
    }
}
