package com.openhouse.admin.controllers;

import javax.servlet.annotation.WebServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.openhouse.factory.DaoFactory;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.daos.StaffDao;
import com.openhouse.services.ParameterService;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.openhouse.beans.StaffMemberTO;

@WebServlet("/actions/staffChange")
@MultipartConfig
public class DoStaffChangeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ParameterService parameterService = ServiceFactory.getParameterService();
    private final StaffDao staffDao = DaoFactory.getStaffDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        StaffMemberTO staffMember = this.parameterService.getStaffMemberTOFromRequest(request);
        
        
        Part filePart = request.getPart("picture");
        InputStream fileContent = filePart.getInputStream();
        File profilePicture = new File(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
        
        try (OutputStream outputStream = new FileOutputStream(profilePicture)) {
            IOUtils.copy(fileContent, outputStream);
        }

        if ("add".equals(request.getParameter("action"))) {
            this.staffDao.addStaffMember(staffMember);
        } else if ("edit".equals(request.getParameter("action"))) {
            this.staffDao.editStaffMember(staffMember);
        }
    }
}