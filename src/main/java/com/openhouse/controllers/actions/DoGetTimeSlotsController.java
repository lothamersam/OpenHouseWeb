package com.openhouse.controllers.actions;

import com.openhouse.daos.AuditionDao;
import com.openhouse.services.ParameterService;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.factory.DaoFactory;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response; 

@Path("/times")
public class DoGetTimeSlotsController {
    private static final long serialVersionUID = 1L;
    
    private static final ParameterService parameterService = ServiceFactory.getParameterService();
    private static final AuditionDao auditionDao = DaoFactory.getAuditionDao();

    @GET
    @Path("/{id}")
    public Response  getTimeSlots(@PathParam int id) {
        return Response.status(200)  
        .entity("test")  
        .build();   
    }
}
