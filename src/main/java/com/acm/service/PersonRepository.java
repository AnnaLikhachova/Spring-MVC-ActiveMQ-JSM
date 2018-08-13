package com.acm.service;

import java.util.Map;

import com.acm.model.Person;

public interface PersonRepository {
	
	public void addPerson(Person person);
	
	public void deletePerson(int id);

	public Person getPerson(int id);

	public Map<String, Person> getAllPersons();
  
}
