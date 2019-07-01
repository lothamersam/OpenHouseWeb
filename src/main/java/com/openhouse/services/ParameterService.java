package com.openhouse.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.IllegalFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.sendgrid.Mail;
import com.sendgrid.Email;
import com.sendgrid.Personalization;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.openhouse.beans.StaffMemberTO;
import com.sendgrid.Content;

public final class ParameterService {
    private static final String CONTACT_DIRECTOR = "Contact Director";

    public Mail getMailFromRequest(HttpServletRequest request) throws IllegalFormatException {
        final Mail mail = new Mail();
        
        final Personalization personalization = new Personalization();
        personalization.addTo(new Email(System.getenv("OPENHOUSE_EMAIL")));
        
        if(CONTACT_DIRECTOR.equals(request.getParameter("category"))) {
            personalization.addCc(new Email(System.getenv("DIRECTOR_EMAIL")));
        }

        final Content content = new Content();
        content.setType("text/html");

        final StringBuilder messageBody = new StringBuilder();
        messageBody.append(String.format("<h3>%s - %s %s</h3><h5>%s", 
                request.getParameter("category"), 
                request.getParameter("firstName"), 
                request.getParameter("lastName"),
                request.getParameter("email")));
       
        if(null != request.getParameter("phoneNumber")) {
            messageBody.append(String.format(" - %s", request.getParameter("phoneNumber")));
        }
        
        messageBody.append("</h5>");
        messageBody.append("<p>" + request.getParameter("message") + "</p>");

        content.setValue(messageBody.toString());
        mail.addContent(content);
        
        mail.addPersonalization(personalization);
        mail.setFrom(new Email(request.getParameter("email")));
        mail.setSubject(String.format("%s - %s %s",         
            request.getParameter("category"), 
            request.getParameter("firstName"), 
            request.getParameter("lastName")));     

        return mail;
    }

    public StaffMemberTO getStaffMemberTOFromRequest(HttpServletRequest request) {
        StaffMemberTO staffMember = new StaffMemberTO();
    
        if(request.getParameter("first_name") != null 
            && request.getParameter("last_name") != null
            && request.getParameter("title") != null
            && request.getParameter("bio") != null
            && request.getParameter("id") != null) {
                staffMember.setFirstName(request.getParameter("first_name"));
                staffMember.setLastName(request.getParameter("last_name"));
                staffMember.setTitle(request.getParameter("title"));
                staffMember.setId(Integer.parseInt(request.getParameter("id")));
                staffMember.setBio(request.getParameter("bio"));
            }

        return staffMember;
    }

    public File getImageFromRequest(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("picture");
        InputStream fileContent = filePart.getInputStream();
        File image = new File(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
        
        try (OutputStream outputStream = new FileOutputStream(image)) {
            IOUtils.copy(fileContent, outputStream);
        }

        return image;
    }
}