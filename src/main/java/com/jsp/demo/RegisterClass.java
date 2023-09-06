package com.jsp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



@WebServlet("/hello")
public class RegisterClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		
		String name=req.getParameter("name");
		PrintWriter printWriter=res.getWriter();
		
		printWriter.print("<html><body><h1> User id :"+id+"</h1></body></html>");
		printWriter.print("<html><body><h1>User name :"+name+"</h1></body></html>");
		
		
	}

}
