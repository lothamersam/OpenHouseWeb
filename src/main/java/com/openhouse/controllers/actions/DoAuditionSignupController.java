package com.openhouse.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.beans.SignupInformationTO;
import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.EmailService;
import com.openhouse.services.ParameterService;

@WebServlet("/action/audition")
public class DoAuditionSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	private final DateDao dateDao = DaoFactory.getDateDao();
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final EmailService emailService = ServiceFactory.getEmailService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final SignupInformationTO signup = this.parameterService.getSignupInformationFromRequest(request);
		
		this.emailService.sendMail(this.parameterService.getSignupMailFromRequest(request));
		int id = this.auditionDao.addAuditionSignup(signup);
		this.dateDao.assignTime(id, Integer.parseInt(request.getParameter("date")));
	}
}
