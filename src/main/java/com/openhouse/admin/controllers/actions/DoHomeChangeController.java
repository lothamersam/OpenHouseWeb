package com.openhouse.admin.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.beans.PageSectionTO;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@WebServlet("/action/admin/homeChange")
public class DoHomeChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ParameterService parameterService = ServiceFactory.getParameterService();
    private final BasicPageDao aboutDao = DaoFactory.getPageDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PageSectionTO aboutSection = this.parameterService.getPageSectionFromRequest(request);

        boolean status = this.aboutDao.editPageSection(aboutSection);

        if(status) {
            response.sendRedirect("/admin/about?success=Successfully performed update!");
        } else {
            response.sendRedirect("/admin/about?error=Your update was not successful!");
        }
    }
}
