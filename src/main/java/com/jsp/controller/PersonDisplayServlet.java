package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Person;
import com.jsp.service.PersonService;
@WebServlet("/displayperson")
public class PersonDisplayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonService personService=new PersonService();
		
		List<Person> list=personService.displayPerson();
		
		for(Person person:list) {
//		IT DISPLAYS THE OUTPUT IN THE CONSOLE:	
			System.out.println(" Person id:"+person.getId());
			System.out.println(" Person name:"+person.getName());
			System.out.println(" Person age:"+person.getAge());
			System.out.println(" Person sal:"+person.getPhoneno());
			System.out.println(" Person email:"+person.getEmail());
			System.out.println(" Person paasword:"+person.getPassword());
//		IT DISPLAYS THE OUTPUT IN THE WEBPAGE:
			    PrintWriter printWriter=resp.getWriter();
	            printWriter.println("<h1>******************************************</h1> ");
	            printWriter.println("<h1>"+person.getId()+"</h1> ");
	            printWriter.println("<h1>"+person.getName()+"</h1> ");
	            printWriter.println("<h1>"+person.getAge()+"</h1> ");
	            printWriter.println("<h1>"+person.getPhoneno()+"</h1> ");
	            printWriter.println("<h1>"+person.getEmail()+"</h1> ");
	            printWriter.println("<h1>"+person.getPassword()+"</h1> ");
	            }
		}
	
}

