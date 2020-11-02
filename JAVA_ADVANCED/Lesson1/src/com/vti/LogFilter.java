package com.vti;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String userName = getCookieByName(req, "username");
		if(userName != null) {
			chain.doFilter(request, response);
		}
		else {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath());
		}
		
	}
	
	private String getCookieByName(HttpServletRequest request,String name) {
    	Cookie[] cookies = request.getCookies();
    	if(cookies == null) {
    		return null;
    	}
    	for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)){
				return cookie.getValue();
			}
		}
    	return null;
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
