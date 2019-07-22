package com.openhouse.admin.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.openhouse.daos.AuditionDao;
import com.openhouse.factory.DaoFactory;

@WebServlet("/action/admin/auditionChange")
public class DoAuditionChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AuditionDao auditionDao = DaoFactory.getAuditionDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		
		if (StringUtils.isNotBlank(request.getParameter("id"))
				&& StringUtils.isNotBlank(request.getParameter("type"))) {
			final int id = Integer.parseInt(request.getParameter("id"));
			
			if("date".equals(request.getParameter("type"))) {
				success = this.auditionDao.deleteAuditionDate(id);
			} else if("signup".equals(request.getParameter("type"))) {
				success = this.auditionDao.deleteAuditionSignup(id);
			}
		}
		
		if(success) {
			response.sendRedirect("/admin/audition?success=Deletion was successful");
		} else {
			response.sendRedirect("/admin/audition?error=Deletion was not successful");
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
