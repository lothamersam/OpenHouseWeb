
package com.openhouse.controllers.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sendgrid.Email;
import com.sendgrid.Content;
import com.sendgrid.Mail;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.Response;
import com.sendgrid.Method;

@WebServlet("/action/email")
public class DoEmailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Email from = new Email("avaschmidt12@gmail.com");
        String subject = "Testing MY EMAIL SERVICE!";
        Email to = new Email("lothamer.sam@gmail.com");
        Content content = new Content("text/plain", "If I make a request to a certain part of nicks website it sends AN EMAIL!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request emailRequest = new Request();
        try {
            emailRequest.method = Method.POST;
            emailRequest.endpoint = "mail/send";
            emailRequest.body = mail.build();
            Response emailResponse = sg.api(emailRequest);
            System.out.println(emailResponse.statusCode);
            System.out.println(emailResponse.body);
            System.out.println(emailResponse.headers);
        } catch (IOException ex) {
            throw ex;
        }

    }
}