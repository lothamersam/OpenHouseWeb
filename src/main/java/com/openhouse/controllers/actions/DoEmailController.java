
package com.openhouse.controllers.actions;

import com.openhouse.services.EmailService;
import com.openhouse.factory.ServiceFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action/email")
public class DoEmailController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final EmailService emailService = ServiceFactory.getEmailService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            response.getWriter().write(emailService.sendFromRequest(request) ? "true" : "false");
    }
}