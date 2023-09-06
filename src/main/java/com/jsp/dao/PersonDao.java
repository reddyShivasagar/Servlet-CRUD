package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Person;

public class PersonDao {

	public  Person savePerson(Person person) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(person!=null) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
		}
		return null;
	}
	
	
	public  Person updatePerson(Person person) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(person!=null) {
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
		return person;
	}
	return null;
	}
	
	public Person deletePerson(int id) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class,id);
		
		if(person!=null) {
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		return person;
		}
	return null;
	}
	
	
    public List<Person> displayPerson() {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sagar");
		EntityManager em=emf.createEntityManager();
		
        Query query=em.createQuery("select alias from Person alias");
       
		return query.getResultList();
    }
    
    
     public Person loginPerson(String email,String password) {
	
  		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sagar");
  	    EntityManager em=emf.createEntityManager();
  		
         Query query=em.createQuery("select alias from Person alias where alias.email=?1 and alias.password=?2");
         query.setParameter(1, email);
         query.setParameter(2, password);
         List<Person> list=query.getResultList();
         
         for(Person person:list) {
  		 
        	 return person;
         }
         return null;
  	}
}

	



