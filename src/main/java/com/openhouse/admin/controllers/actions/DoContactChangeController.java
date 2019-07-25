//package com.openhouse.admin.controllers.actions;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.openhouse.beans.PageSectionTO;
//import com.openhouse.daos.BasicPageDao;
//import com.openhouse.factory.DaoFactory;
//import com.openhouse.factory.ServiceFactory;
//import com.openhouse.services.ParameterService;
//
//@WebServlet("/action/admin/contactChange")
//public class DoContactChangeController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private final ParameterService parameterService = ServiceFactory.getParameterService();
//	private final BasicPageDao pageDao = DaoFactory.getPageDao();
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		PageSectionTO pageSection = this.parameterService.getPageSectionFromRequest(request);
//
//		boolean status = this.pageDao.editPageSection(pageSection);
//
//		if (status) {
//			response.sendRedirect("/admin/contact?success=Successfully performed update!");
//		} else {
//			response.sendRedirect("/admin/contact?error=Your update was not successful!");
//		}
//	}
//}
