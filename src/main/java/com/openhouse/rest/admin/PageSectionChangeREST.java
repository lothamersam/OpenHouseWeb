package com.openhouse.rest.admin;

import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response; 

import com.openhouse.beans.PageSectionTO;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@Path("/admin/page")
public class PageSectionChangeREST {	
	private final ParameterService parameterService = ServiceFactory.getParameterService();
    	private final BasicPageDao aboutDao = DaoFactory.getPageDao();
    
    @POST
    @Path("/change")
    public Response changeHomeSection() {
    	PageSectionTO aboutSection = this.parameterService.getPageSectionFromRequest(request);

        //boolean status = this.aboutDao.editPageSection(aboutSection);

        return Response.status(200)  
          .entity("test")  
          .build();  
    }
}
