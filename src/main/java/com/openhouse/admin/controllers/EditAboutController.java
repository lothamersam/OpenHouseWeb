package com.openhouse.admin.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.AboutDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.services.enums.AboutSectionType;

@WebServlet("/admin/about")
public class EditAboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AboutDao aboutDao = DaoFactory.getAboutDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setRequestAttributes(request);
		
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminAbout.jsp").forward(request, response);
	}
	
	private void setRequestAttributes(HttpServletRequest request) {
		for(AboutSectionType sectionType : AboutSectionType.values()) {
			request.setAttribute(sectionType.getSectionType(), aboutDao.getAboutSection(sectionType));
		}
		
		request.setAttribute("googleApiKey", System.getenv("GOOGLE_API_KEY"));
	}
}
