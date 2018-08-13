package com.acm.service;

import java.util.List;
import java.util.Map;

import com.acm.model.Person;

public interface PersonService {
   
	public void addPerson(Person person);
 
    public void deletePerson(Person person, int personId);
 
    public Person find(int personId);
 
    public List < Person > findAll();
}
