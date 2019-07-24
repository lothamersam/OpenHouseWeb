package com.openhouse.rest;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/login")
public class LoginREST {

	@POST
	public Response verifyUserAndLogin(@Context UriInfo uriInfo, 
      			@Context HttpServletRequest request,
			@FormParam("username") String username,
			@FormParam("password") String password) {

    System.out.println(username + " " + password);
    
    request.setAttribute("user", "test");

		return Response.seeOther(uriInfo.getBaseUriBuilder().path("../admin/").build()).build();
	}
}
