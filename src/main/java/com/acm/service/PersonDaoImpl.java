package com.acm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acm.model.Person;

@Repository
@Qualifier("personDao")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addPerson(Person person) {
		jdbcTemplate.update("INSERT INTO names (name, surname) VALUES (?, ?)", person.getName(), person.getSurname());
		System.out.println("Person Added!!");
	}

	public void editPerson(Person person, int personId) {
		jdbcTemplate.update("UPDATE names SET name = ? , surname = ? WHERE id = ? ", person.getName(),
				person.getSurname(), personId);
		System.out.println("Person Updated!!");
	}

	public void deletePerson(int personId) {
		jdbcTemplate.update("DELETE from names WHERE id = ? ", personId);
		System.out.println("Person Deleted!!");
	}

	public Person find(int personId) {
		Person person = (Person) jdbcTemplate.queryForObject("SELECT * FROM names where id = ? ",
				new Object[] { personId }, new BeanPropertyRowMapper(Person.class));

		return person;
	}

	public List<Person> findAll() {
		try {
			List<Person> persons = jdbcTemplate.query("SELECT * FROM names", new BeanPropertyRowMapper(Person.class));
			return persons;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
