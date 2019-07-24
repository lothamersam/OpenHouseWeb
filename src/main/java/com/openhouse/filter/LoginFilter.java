package com.openhouse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		if(!session.isNew() && session.getAttribute("user") != null) {				
			chain.doFilter(request, response);
		} else if(session.isNew() || session.getAttribute("user") == null){
			httpResponse.sendRedirect("/login");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
        // no implementation necessary
	}

    @Override
	public void destroy() {
        // no implementation necessary
	}
}
