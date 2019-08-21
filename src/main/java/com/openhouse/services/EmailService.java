package com.openhouse.services;

import java.io.IOException;
import java.util.IllegalFormatException;

import com.sendgrid.Mail;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.Response;
import com.sendgrid.Method;

public class EmailService {
    public boolean sendMail(final Mail mail) {
        final SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        boolean status = false;

        try {
            final Request emailRequest = buildEmailRequest(mail);
            final Response emailResponse = sendGrid.api(emailRequest);
        
            if(emailResponse.statusCode == 200 || emailResponse.statusCode == 202){
                status = true;
            }
        } catch (IOException|IllegalFormatException exception) {
            System.out.println("Error sending mail!");
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