package com.jsp.service;

import java.util.List;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Person;

public class PersonService {
	
	  PersonDao dao=new PersonDao();
	 
      public Person savePerson(Person person) {
    	  return dao.savePerson(person);
	}
     
      public Person updatePerson(Person person) {
  		
  		  return dao.updatePerson(person);
      }
      
      public Person deletePerson(int id) {
		
   	      return dao.deletePerson(id);
   	   
      }

      public List <Person> displayPerson() {
  		
		  return dao.displayPerson();
		   
	   }
   
	  public Person loginPerson(String email,String password) {
		   return dao.loginPerson(email, password);
	   }
	   
}
