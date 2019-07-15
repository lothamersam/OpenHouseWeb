package com.openhouse.admin.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.beans.AboutSectionTO;
import com.openhouse.daos.AboutDao;
import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.services.ParameterService;

@WebServlet("/admin/about")
public class DoAboutChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private final ParameterService parameterService = ServiceFactory.getParameterService();
    private final AboutDao aboutDao = DaoFactory.getAboutDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	AboutSectionTO aboutSection = this.parameterService.getAboutSectionFromRequest(request);

        boolean status = this.aboutDao.editAboutSection(aboutSection);

        if(status) {
            response.sendRedirect("/admin/about?success=Successfully performed update!");
        } else {
            response.sendRedirect("/admin/about?error=Your update was not successful!");
        }
    }
}
