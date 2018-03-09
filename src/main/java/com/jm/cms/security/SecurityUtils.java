package com.jm.cms.security;


import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {


    private static final ObjectMapper mapper = new ObjectMapper();


    private SecurityUtils() {
    }
 
    public static void sendError(HttpServletResponse response, Exception exception, int status, String message) throws IOException {
      
    	  response.setContentType("application/json;charset=UTF-8");
          response.setStatus(status);
          PrintWriter writer = response.getWriter();
          //ErrorMessageDTO error = new ErrorMessageDTO(ErrorMessageType.INFO, exception.getMessage());          
          writer.write(mapper.writeValueAsString(exception.getMessage()));
          writer.flush();
          writer.close();
    }

    public static void sendResponse (HttpServletResponse response, HttpStatus status, Object object ) throws IOException {
   
    	response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(object));
        response.setStatus(status.value());
        writer.flush();
        writer.close();
    		 
    }
    
   

   
}
