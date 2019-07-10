package com.openhouse.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("aboutUsSnippet", "<p>This is temorary placeholder text</p>");
		request.setAttribute("organizationAddress", "<p>This is temorary placeholder text</p>");
		
		request.getRequestDispatcher("/WEB-INF/pages/about.jsp").forward(request, response);
	}
}
