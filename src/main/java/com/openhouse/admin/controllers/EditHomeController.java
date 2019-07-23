package com.openhouse.admin.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.BasicPageDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.services.enums.PageSectionType;

@WebServlet("/admin/home")
public class EditHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final BasicPageDao pageDao = DaoFactory.getPageDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setRequsetAttributes(request);
		
		request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void setRequsetAttributes(HttpServletRequest request) {
		request.setAttribute("homeTop", this.pageDao.getPageSection(PageSectionType.HOME_TOP));
		request.setAttribute("homeCollapseOne", this.pageDao.getPageSection(PageSectionType.HOME_COLLAPSE_ONE));
		request.setAttribute("homeCollapseTwo", this.pageDao.getPageSection(PageSectionType.HOME_COLLAPSE_TWO));
		request.setAttribute("homeCollapseThree", this.pageDao.getPageSection(PageSectionType.HOME_COLLAPSE_THREE));
		request.setAttribute("homeCol", this.pageDao.getPageSection(PageSectionType.HOME_COL_ONE));
		request.setAttribute("homeCol", this.pageDao.getPageSection(PageSectionType.HOME_COL_TWO));
		request.setAttribute("homeCol", this.pageDao.getPageSection(PageSectionType.HOME_COL_THREE));
	}
}
