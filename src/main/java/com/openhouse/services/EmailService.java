package com.openhouse.services;

import com.sendgrid.Email;

import java.io.IOException;
import java.util.IllegalFormatException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.node.ObjectNode;

import com.openhouse.factory.ServiceFactory;

import com.sendgrid.Content;
import com.sendgrid.Mail;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.Response;
import com.sendgrid.Method;

public class EmailService {
    private static final ParameterService parameterService = ServiceFactory.getParameterService();

    public boolean sendFromRequest(HttpServletRequest request) {
        final SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        boolean status = false;

        try {
            final Mail mail = parameterService.getMailFromRequest(request);
            final Request emailRequest = buildEmailRequest(mail);
            final Response emailResponse = sendGrid.api(emailRequest);
        
            if(emailResponse.statusCode == 200 || emailResponse.statusCode == 202){
                status = true;
            }
        } catch (IOException|IllegalFormatException exception) {
            status = false;
        }
        
        return status;
    }

    private Request buildEmailRequest(final Mail mail) throws IOException {
        final Request emailRequest = new Request();

        emailRequest.method = Method.POST;
        emailRequest.endpoint = "mail/send";
        emailRequest.body = mail.build();

        return emailRequest;
    }

}