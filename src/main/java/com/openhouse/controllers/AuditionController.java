package com.openhouse.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auditionss")
public class AuditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final List<String> date = new ArrayList<>();
		
		date.add("2019-7-19");
		request.setAttribute("auditionDates", date);
		request.setAttribute("auditionInformation", "temp");
		
		request.getRequestDispatcher("/WEB-INF/pages/audition.jsp").forward(request, response);
	}
}
