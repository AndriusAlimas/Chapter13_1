package com.andrius.project.Chapter13_1.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
		
		PrintWriter out = response.getWriter();
		out.println("Success!!");
	}
}
