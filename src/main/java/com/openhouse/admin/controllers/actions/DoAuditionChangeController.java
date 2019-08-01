package com.openhouse.admin.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.openhouse.beans.DateTO;
import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;
import com.openhouse.services.enums.DateType;

@WebServlet("/action/admin/auditionChange")
public class DoAuditionChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	private final DateDao dateDao = DaoFactory.getDateDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = false;
		
		if (StringUtils.isNotBlank(request.getParameter("id"))
				&& StringUtils.isNotBlank(request.getParameter("type"))) {
			final int id = Integer.parseInt(request.getParameter("id"));
			
			if("date".equals(request.getParameter("type"))) {
				status = this.dateDao.removeDate(id);
			} else if("signup".equals(request.getParameter("type"))) {
				status = this.auditionDao.deleteAuditionSignup(id);
			}
		}
		
		redirect(response, status);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean status = false; 
		
		if("true".equals(request.getParameter("isDate"))) {
			DateTO date = this.parameterService.getDateFromRequest(request);
			date.setType(DateType.AUDITION);
			status = this.dateDao.addDate(date);
		} 
		
		redirect(response, status);
	}
	
	private void redirect(HttpServletResponse response, boolean status) throws ServletException, IOException {
		if (status) {
			response.sendRedirect("/admin/auditions?success=Successfully performed update!");
		} else {
			response.sendRedirect("/admin/auditions?error=Your update was not successful!");
		}
	}
}
