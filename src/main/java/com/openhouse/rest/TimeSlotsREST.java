package com.openhouse.rest;

import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/times")
public class TimeSlotsREST {
	private final DateDao dateDao = DaoFactory.getDateDao();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTimeSlots(@PathParam("id") int id) {
		int status = 500;
		final JSONObject timesList = this.dateDao.getTimes(id);

		if (timesList.has("times")) {
			status = 200;
		}

		return Response.status(status).entity(timesList.toString()).build();
	}
}
