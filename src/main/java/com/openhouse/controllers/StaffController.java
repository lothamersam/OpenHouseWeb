package com.openhouse.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.factory.DaoFactory;
import com.openhouse.daos.StaffDao;

@WebServlet("/staff")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StaffDao staffDao = DaoFactory.getStaffDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("staffMembers", staffDao.getStaffList());

		request.getRequestDispatcher("/WEB-INF/pages/staff.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
