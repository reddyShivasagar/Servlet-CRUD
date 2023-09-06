package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Person;
import com.jsp.service.PersonService;

@WebServlet("/personlogin")
public class LoginPersonServlet extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	PersonService ps=new PersonService();
	Person person=ps.loginPerson(email, password);
	
	if(person!=null) {
	
		RequestDispatcher rd=req.getRequestDispatcher("PersonHomePage.html");
	    rd.forward(req,resp);
	}
    else {
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req,resp);
	}
}
}
