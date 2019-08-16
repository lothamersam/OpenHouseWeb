package com.openhouse.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.openhouse.beans.SignupInformationTO;
import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.EmailService;
import com.openhouse.services.ParameterService;

@Path("/signup")
public class SignupREST {

	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	private final DateDao dateDao = DaoFactory.getDateDao();
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final EmailService emailService = ServiceFactory.getEmailService();
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("squid:S00107")
	public Response signup(
			@FormParam("first_name") String firstName,
			@FormParam("last_name") String lastName,
			@FormParam("pronoun") String pronoun,
			@FormParam("dateText") String dateText,
			@FormParam("timeText") String timeText,
			@FormParam("email") String email,
			@FormParam("phone_number") String phoneNumber,
			@FormParam("time") int time) {
		final JSONObject responseBody = new JSONObject();
		final SignupInformationTO signup = this.parameterService.getSignupInformationFromRequest(
				firstName, lastName, pronoun, dateText, timeText, email, phoneNumber);

		int id = this.auditionDao.addAuditionSignup(signup);		
		
		if(this.dateDao.assignTime(id, time) && 
				this.emailService.sendMail(this.parameterService.getSignupMailFromRequest(
						firstName, lastName, email, dateText, timeText))) {
			responseBody.put("message", "You have signed up successfully!");
		} else {
			responseBody.put("message", "We are sorry, your signup could "
					+ "not be processed at this time.");
		}
		
		return Response.status(200).entity(responseBody.toString()).build();
	}
		
}
