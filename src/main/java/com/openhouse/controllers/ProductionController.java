package com.openhouse.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.daos.BasicPageDao;
import com.openhouse.daos.DateDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.services.enums.DateType;
import com.openhouse.services.enums.PageSectionType;

@WebServlet("/upcoming")
public class ProductionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BasicPageDao pageDao = DaoFactory.getPageDao();
	private final DateDao dateDao = DaoFactory.getDateDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productionDates", this.dateDao.getDates(DateType.PRODUCTION));
		request.setAttribute("productionSection", 
				this.pageDao.getPageSection(PageSectionType.PRODUCTION_PAGE_SECTION));
		
		request.getRequestDispatcher("/WEB-INF/pages/upcomingProductions.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
