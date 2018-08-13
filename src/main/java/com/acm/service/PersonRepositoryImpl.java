package com.acm.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.acm.model.Person;


@Service("personRepository")
public class PersonRepositoryImpl implements PersonRepository{

	private final Map<String, Person> persons = new ConcurrentHashMap<String, Person>();
	
	@Override
	public void addPerson(Person person) {
		persons.put(String.valueOf(person.getId()), person);		
	}

	@Override
	public Person getPerson(int id) {
		return persons.get(id);
		
	}

	@Override
	public Map<String, Person> getAllPersons() {	
		return persons;
	}

	@Override
	public void deletePerson(int id) {
		persons.remove(id);
	}
	
}
