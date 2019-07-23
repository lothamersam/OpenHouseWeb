package com.openhouse.rest;

import com.openhouse.services.EmailService;
import com.openhouse.services.ParameterService;
import com.openhouse.factory.ServiceFactory;

import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.FormParam;  
import javax.ws.rs.core.Response; 


@Path("/email")
public class DoEmailREST {  
    private static final EmailService emailService = ServiceFactory.getEmailService();
    private static final ParameterService parameterService = ServiceFactory.getParameterService();

    @POST
    @Path("/send")
    protected Response doSendEmail(@FormParam("firstName") String firstName) {
      
      return Response.status(200)  
        .entity(name)  
        .build(); 
    }
}
