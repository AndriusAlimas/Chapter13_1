package com.andrius.project.Chapter13_1.filter;
import java.io.*;
import javax.servlet.*; // Filter and FilterChain are in javax.servlet
import javax.servlet.http.HttpServletRequest;

// Every filter MUST implement the Filter interface
public class RequestFilter implements Filter{

	private FilterConfig fc;
	
	// You must implement init(), usually you just save the config object:
	public void init(FilterConfig fc)throws ServletException{
		this.fc = fc;
	}
	
	// doFilter() is where you do the real work... Notice that the method doesn't
	// take HTTP request or response objects... just regular ServletRequest 
	// and ServletResponse objects:
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)throws ServletException,IOException{
		// But we're pretty sure that we can cast the request and response
		// to their HTTP subtypes:
		HttpServletRequest httpReq = (HttpServletRequest)request;
		
		String name = httpReq.getRemoteUser();
		
		if(name != null){
			fc.getServletContext().log("User " + name + " is updating..." );
		}
		
		// This is how the next filter or servlet in line gets called:
		chain.doFilter(request, response);
		
	}
	
	// You must implement destroy() but usually it's empty
	public void destroy() {
		// do cleanup stuff
	}

}
