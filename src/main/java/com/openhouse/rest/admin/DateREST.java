package com.openhouse.rest.admin;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import com.openhouse.beans.DateTO;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@Path("/admin/date")
public class DateREST {
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final DateDao dateDao = DaoFactory.getDateDao();

	@POST
	@Path("/add/{referrer}")
	public Response addDate(@Context UriInfo uriInfo, 
			@PathParam("referrer") String referrer,
			@FormParam("date") String date,
			@FormParam("location") String location,
			@FormParam("time") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("information") String information) {
		DateTO dateTo = this.parameterService.getDateFromRequest(date,
				location, 
				startTime,
				endTime,
				information);

		this.dateDao.addDate(dateTo);
		
		return Response.seeOther(uriInfo.getBaseUriBuilder().path("../admin/" + referrer).build()).build();
	}
	
	@GET
	@Path("/delete/{id}/{referrer}")
	public Response removeDate(@Context UriInfo uriInfo, 
			@PathParam("id") int id,
			@PathParam("referrer") String referrer) {
		final JSONObject responseBody = new JSONObject();
		
		if (this.dateDao.removeDate(id)) {
			responseBody.put("message", "Date removed successfully!");
		} else {
			responseBody.put("message", "Could not remove date!");
		}
		

		return Response.seeOther(uriInfo.getBaseUriBuilder().path("../admin/" + referrer).build()).build();
	}
	
}
