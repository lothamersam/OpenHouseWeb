package com.openhouse.rest;

import com.openhouse.services.EmailService;
import com.openhouse.services.ParameterService;
import com.openhouse.factory.ServiceFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.sendgrid.Mail;

@Path("/email")
public class EmailREST {
	private final EmailService emailService = ServiceFactory.getEmailService();
	private final ParameterService parameterService = ServiceFactory.getParameterService();

	@POST
	@Path("/send")
	public Response doSendEmail(@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName,
			@FormParam("email") String email, 
			@FormParam("phoneNumber") String phoneNumber,
			@FormParam("category") String category,
			@FormParam("message") String message) {

		int status = 500; 
		final JSONObject responseBody = new JSONObject().put("success", false);
		
		final Mail mail = this.parameterService.getContactMailFromRequest(firstName, lastName, email, phoneNumber,
				category, message);

		if (this.emailService.sendMail(mail)) {
			status = 200;
			responseBody.put("success", true);
		} 
		
		return Response.status(status).entity(responseBody.toString()).build();
	}
}
