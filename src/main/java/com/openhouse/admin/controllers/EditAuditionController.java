package com.openhouse.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.AuditionDao;
import com.openhouse.factory.DaoFactory;

@WebServlet("/actions/auditions")
public class EditAuditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("auditionDates", auditionDao.getAuditionDate());
		request.setAttribute("auditionInformation", auditionDao.getAuditionSection());	
		
		request.getRequestDispatcher("/WEB-INF/pages/audition.jsp").forward(request, response);
	}
}
