package com.ironyard.doorway.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class ServletHandler extends AbstractHandler {

	public ServletHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if(target != null && !target.toLowerCase().contains("servlet")) {
			return;
		}
		System.out.println("target=" + target);
		
        if(target.contains("signon")) {
        	signOn(target, request, response);
        }
        else if(target.contains("signup")) {
        	signUp(target, request, response);
        }
        else {
        	System.err.println("UNHANDLED CALL!");
        	return;
        }
        baseRequest.setHandled(true);
	}
	
	private void signOn(String target, HttpServletRequest request, 
						HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		// TODO need to use userDAO
		
		Cookie cookie = new Cookie("userId", userId);
		cookie.setPath("/");
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		System.out.println("Wrote cookie userId=" + userId);
		System.out.println("Redirect to main.html");
		
		response.sendRedirect("/main.html");
	}
	
	private void signUp(String target, HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		// TODO need to use userDAO
		
		Cookie cookie = new Cookie("userId", userId);
		cookie.setPath("/");
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		System.out.println("Wrote cookie userId=" + userId);
		System.out.println("Redirect to main.html");
		
		response.sendRedirect("/main.html");
	}
}
