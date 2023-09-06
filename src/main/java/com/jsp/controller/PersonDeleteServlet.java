package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Person;
import com.jsp.service.PersonService;

@WebServlet("/deleteperson")
public class PersonDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		PersonService personService=new PersonService();
		Person person= personService.deletePerson(id);
		
		if(person!=null) {
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<h1>"+id+" data deleted in person table </h1> ");
		}
	}

}
