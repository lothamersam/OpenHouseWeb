package com.openhouse.admin.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.UserDao;
import com.openhouse.factory.DaoFactory;

@WebServlet("/admin/users")
public class EditUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserDao userDao = DaoFactory.getUserDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("userList", this.userDao.getUserList());
		request.setAttribute("signedOnUser", request.getSession().getAttribute("user"));
		
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminUsers.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
