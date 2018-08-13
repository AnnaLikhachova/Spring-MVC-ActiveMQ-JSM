package com.acm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acm.model.Person;
import com.acm.service.PersonService;

@Controller
public class AppController {

	@Autowired
	@Qualifier("personService")
	PersonService personService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String prepareProduct(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
	public String prepare(ModelMap model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "addPerson";
	}

	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("person") Person person, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addPerson";
		}
		personService.addPerson(person);
		model.addAttribute("success", "Person " + person.getName() + " " + person.getSurname() + " is registered.");
		return "success";
	}

	@RequestMapping(value = { "/status" }, method = RequestMethod.GET)
	public String checkOrderStatus(@ModelAttribute("person") Person person, ModelMap model,
			@RequestParam(required = false) String delete) {
		List<Person> persons = personService.findAll();
		model.addAttribute("persons", persons);
		return "status";
	}
	
	@RequestMapping(value = { "/status" }, method = RequestMethod.POST)
	public String delete(@ModelAttribute("person") Person person, ModelMap model,
			@RequestParam(required = false) String delete, @RequestParam(required = false) Integer id) {
		List<Person> persons = personService.findAll();
		if (delete != null) {
			person = null;
			person = personService.find(id);
			if(persons.contains(person)) {
			personService.deletePerson(person, person.getId());
			persons = personService.findAll();
			}
		}
		model.addAttribute("persons", persons);
		model.addAttribute("status", "Person " + person.getName() + " " + person.getSurname() + " is deleted.");
		return "status";
	}

}
