package com.openhouse.filter;

import javax.servlet.Filter;

public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
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
