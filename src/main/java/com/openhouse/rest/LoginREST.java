package com.openhouse.rest;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;

import com.openhouse.beans.UserTO;
import com.openhouse.daos.UserDao;
import com.openhouse.factory.DaoFactory;

@Path("/login")
public class LoginREST {
	private final UserDao userDao = DaoFactory.getUserDao();

	@POST
	public Response verifyUserAndLogin(
			@Context HttpServletRequest request, 
			@FormParam("username") String username,
			@FormParam("password") String password) {
		boolean success = false;
		String redirectPath = "../login?error=Invalid credentials!";
		
		final UserTO user = this.userDao.getUser(username);

		if (StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())) {
			success = BCrypt.checkpw(password, BCrypt.gensalt(10));
		}

		if (success) {
			redirectPath = "../admin";
		}

		return Response.seeOther(URI.create(redirectPath)).build();
	}
}
