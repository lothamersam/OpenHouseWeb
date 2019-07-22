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

@WebServlet("/contact")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BasicPageDao pageDao = DaoFactory.getPageDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("auditionSection", this.pageDao.getPageSection(PageSectionType.CONTACT_SECTION));
		
		request.getRequestDispatcher("/WEB-INF/pages/contact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
