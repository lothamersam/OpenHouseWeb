package com.openhouse.rest.admin;

import java.net.URI;

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
import org.mindrot.jbcrypt.BCrypt;

import com.openhouse.beans.UserTO;
import com.openhouse.daos.UserDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@Path("/admin/users")
public class UserREST {
	private static final String PATH = "../admin/users";
	private final UserDao userDao = DaoFactory.getUserDao();
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	
	@POST
	@Path("/add")
	public Response createUser(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("username") String username,
			@FormParam("password") String password) {
		
		final String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		final UserTO user = this.parameterService
				.getUserFromRequest(firstName, lastName, username, hashedPassword);
		final JSONObject responseBody = this.userDao.addUser(user);
		
		return Response.seeOther(URI.create(PATH)).entity(responseBody.toString()).build();
	}
	
	@POST
	@Path("/change")
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeUserPassword(@Context UriInfo uriInfo,
			@Context HttpServletRequest request,
			@FormParam("id") int id,
			@FormParam("oldPass") String oldPass,
			@FormParam("password") String password) {
		final String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		
		final UserTO user = this.parameterService.getUserFromRequest(id, hashedPassword);
		final JSONObject responseBody = this.userDao.updateUser(user, oldPass);
		
		return Response.status(200).entity(responseBody.toString()).build();
	}
	
	@GET
	@Path("/delete/{id}")
	public Response removeUser(@PathParam("id") int id) {
		final JSONObject responseBody = this.userDao.removeUser(id);
		
		return Response.seeOther(URI.create(PATH)).build();
	}
}
