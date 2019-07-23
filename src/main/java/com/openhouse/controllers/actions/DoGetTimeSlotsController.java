package com.openhouse.controllers.actions;

import com.openhouse.daos.AuditionDao;
import com.openhouse.services.ParameterService;
import com.openhouse.factory.ServiceFactory;
import com.openhouse.factory.DaoFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action/times")
public class DoGetTimeSlotsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final ParameterService parameterService = ServiceFactory.getParameterService();
    private static final AuditionDao auditionDao = DaoFactory.getAuditionDao();

    //TODO: Change return JSON
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            response.getWriter().write("true");
    }
}
