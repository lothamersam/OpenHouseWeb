package com.openhouse.admin.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.AuditionDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.services.enums.PageSectionType;

@WebServlet("/actions/audition")
public class EditAuditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("auditionDates", this.auditionDao.getAuditionDate());
		request.setAttribute("auditionInformation", this.auditionDao.getPageSection(PageSectionType.AUDITION_SECTION));	
		request.setAttribute("signupInformation", this.auditionDao.getAuditionSignups());
		
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminAudition.jsp").forward(request, response);
	}
}
