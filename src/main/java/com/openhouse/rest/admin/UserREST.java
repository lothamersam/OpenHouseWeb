package com.openhouse.rest.admin;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import com.openhouse.beans.UserTO;
import com.openhouse.daos.UserDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@Path("/admin/users")
public class UserREST {
	private final UserDao userDao = DaoFactory.getUserDao();
	private final ParameterService parameterService = ServiceFactory.getParameterService();

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("username") String username,
			@FormParam("password") String password) {
		
		final String hashedPassword = password;
		final UserTO user = this.parameterService
				.getUserFromRequest(firstName, lastName, username, hashedPassword);
		final JSONObject responseBody = this.userDao.addUser(user);
		
		return Response.status(200).entity(responseBody.toString()).build();
	}
	
	@POST
	@Path("/change")
	@Produces(MediaType.APPLICATION_JSON)
	public Response chageUserPassword(@Context UriInfo uriInfo, 
			@Context HttpServletRequest request,
			@FormParam("username") String username,
			@FormParam("password") String password) {
		final String hashedPassword = password;
		final UserTO user = this.parameterService.getUserFromRequest(username, hashedPassword);
		final JSONObject responseBody= this.userDao.updateUser(user);
		
		return Response.status(200).entity(responseBody.toString()).build();
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeUser(@PathParam("id") int id) {
		final JSONObject responseBody = this.userDao.removeUser(id);
		
		return Response.status(200).entity(responseBody.toString()).build();
	}

}
