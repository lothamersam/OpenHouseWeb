package com.openhouse.admin.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.openhouse.beans.PageSectionTO;
import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@WebServlet("/action/admin/auditionChange")
public class DoAuditionChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ParameterService parameterService = ServiceFactory.getParameterService();
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	private final DateDao dateDao = DaoFactory.getDateDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		
		if (StringUtils.isNotBlank(request.getParameter("id"))
				&& StringUtils.isNotBlank(request.getParameter("type"))) {
			final int id = Integer.parseInt(request.getParameter("id"));
			
			if("date".equals(request.getParameter("type"))) {
				success = this.dateDao.removeDate(id);
			} else if("signup".equals(request.getParameter("type"))) {
				success = this.auditionDao.deleteAuditionSignup(id);
			}
		}
		
		if(success) {
			response.sendRedirect("/admin/audition?success=Deletion was successful");
		} else {
			response.sendRedirect("/admin/audition?error=Deletion was not successful");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageSectionTO pageSection = this.parameterService.getPageSectionFromRequest(request);

		boolean status = this.auditionDao.editPageSection(pageSection);

		if (status) {
			response.sendRedirect("/admin/audition?success=Successfully performed update!");
		} else {
			response.sendRedirect("/admin/audition?error=Your update was not successful!");
		}
	}
}
