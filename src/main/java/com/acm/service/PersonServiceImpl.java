package com.acm.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.messaging.MessageSender;
import com.acm.model.Person;
import com.acm.model.PersonStatus;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	MessageSender messageSender;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonDao personDao;

	public void addPerson(Person person) {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		personDao.addPerson(person);
		person.setStatus(PersonStatus.CREATED);
		personRepository.addPerson(person);
		LOG.info("Application : sending request adding person{}", person);
		messageSender.sendMessage(person);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public void deletePerson(Person person,int personId) {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		personDao.deletePerson(personId);
		person.setStatus(PersonStatus.DELETED);
		personRepository.deletePerson(personId);
		LOG.info("Application : sending request deleting person{}", person);
		messageSender.sendMessage(person);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}

	public Person find(int personId) {
		return personDao.find(personId);
	}

	public List<Person> findAll() {
		return personDao.findAll();
	}

}
