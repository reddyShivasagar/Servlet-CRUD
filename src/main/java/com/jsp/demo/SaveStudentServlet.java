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


@WebServlet("/save")
public class SaveStudentServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int id = Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	int age= Integer.parseInt(req.getParameter("age"));
	
	Student student1=new Student();
	
             student1.setId(id);
             student1.setName(name);
             student1.setAge(age);

             EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
             EntityManager entityManager=entityManagerFactory.createEntityManager();
             EntityTransaction entityTransaction=entityManager.getTransaction();

             entityTransaction.begin();
             entityManager.persist(student1);
             entityTransaction.commit();
             
            PrintWriter printWriter=resp.getWriter();
            printWriter.println("<h1>"+name+"data saved in student table</h1> ");
}
}

