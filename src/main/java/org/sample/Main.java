package org.sample;

import org.sample.dao.PersonDao;
import org.sample.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Context.xml");
		PersonDao personDao = context.getBean(PersonDao.class);
		personDao.save(new Person("Erich", "Gamma"));
	    Person person = new Person("Kent", "Beck");
	    personDao.save(person);
	    personDao.save(new Person("Ralph", "Johnson"));
	    Person personFromDb = personDao.findPersonsByFirstnameQueryDSL("Kent").get(0);
	    System.out.println(personFromDb.getFirstname());
	    System.out.println(personFromDb.getSurname());
	    context.close();
	}
}
