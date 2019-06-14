package com.openhouse.services;

import java.util.IllegalFormatException;

import javax.servlet.http.HttpServletRequest;

import com.sendgrid.Mail;
import com.sendgrid.Email;
import com.sendgrid.Personalization;

import org.apache.http.entity.ContentType;

import com.sendgrid.Content;

public final class ParameterService {
    private static final String CONTACT_DIRECTOR = "Contact Director";

    public Mail getMailFromRequest(HttpServletRequest request) throws IllegalFormatException {
        Mail mail = new Mail();
        
        Personalization personalization = new Personalization();
        personalization.addTo(new Email(System.getenv("OPENHOUSE_EMAIL")));
        
        if(CONTACT_DIRECTOR.equals(request.getParameter("subject"))) {
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
}