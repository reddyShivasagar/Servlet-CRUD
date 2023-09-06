package com.jsp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age= Integer.parseInt(req.getParameter("age"));
		
		Student student=new Student();
		
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sagar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(student);
		et.commit();
		PrintWriter printWriter=resp.getWriter();
		printWriter.println("<h1>"+name+"data update from student table</h1>");
	}

}
