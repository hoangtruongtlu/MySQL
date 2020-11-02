package com.vti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("username");
		request.getCookies();
		
		String userName = getCookieByName(request, "username");
		
		if(userName!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("Login.jsp");
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

}
