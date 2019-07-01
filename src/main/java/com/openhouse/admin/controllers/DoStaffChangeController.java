package com.openhouse.admin.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.daos.StaffDao;
import com.openhouse.services.ImageService;
import com.openhouse.services.ParameterService;
import com.openhouse.beans.StaffMemberTO;

@WebServlet("/action/staffChange")
@MultipartConfig
public class DoStaffChangeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ParameterService parameterService = ServiceFactory.getParameterService();
    private final ImageService imageService = ServiceFactory.getImageService();
    private final StaffDao staffDao = DaoFactory.getStaffDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        StaffMemberTO staffMember = this.parameterService.getStaffMemberTOFromRequest(request);
        File image = this.parameterService.getImageFromRequest(request);

        staffMember.setImagePath(this.imageService.uploadImage(image));

        boolean status = false;
        if ("add".equals(request.getParameter("action"))) {
            status = this.staffDao.addStaffMember(staffMember);
        } else if ("edit".equals(request.getParameter("action"))) {
            this.staffDao.editStaffMember(staffMember);
        }

        if(status) {
            response.sendRedirect("/admin/staff?success=Successfully performed update!");
        } else {
            response.sendRedirect("/admin/staff?error=Your update was not successful!");
        }
    }
}