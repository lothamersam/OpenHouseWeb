package com.openhouse.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.BasicPageDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.services.enums.PageSectionType;

@WebServlet("/about")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BasicPageDao aboutDao = DaoFactory.getPageDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setRequestAttributes(request);
		
		request.getRequestDispatcher("/WEB-INF/pages/about.jsp").forward(request, response);
	}

	private void setRequestAttributes(HttpServletRequest request) {
		for(PageSectionType sectionType : PageSectionType.values()) {
			request.setAttribute(sectionType.getSectionType(), aboutDao.getPageSection(sectionType));
		}
		
		request.setAttribute("googleApiKey", System.getenv("GOOGLE_API_KEY"));
	}
}
