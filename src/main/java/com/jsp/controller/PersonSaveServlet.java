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


@WebServlet("/saveperson")
public class PersonSaveServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age= Integer.parseInt(req.getParameter("age"));
		long phoneno= Long.parseLong(req.getParameter("phoneno"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		         Person person=new Person();
		
	             person.setId(id);
	             person.setName(name);
	             person.setAge(age);
	             person.setPhoneno(phoneno);
	             person.setEmail(email);
	             
	             person.setPassword(password);
	             
	             PersonService personService=new PersonService();
                 Person person2= personService.savePerson(person);
	             
          
	            PrintWriter printWriter=resp.getWriter();
	            printWriter.println("<h1>"+name+" data saved in person table</h1> ");
	}
}

