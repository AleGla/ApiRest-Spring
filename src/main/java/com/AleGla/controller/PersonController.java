package com.AleGla.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.AleGla.models.Person;
import com.AleGla.models.PersonModify;
import com.AleGla.models.PersonRequest;
import com.AleGla.response.PersonResponse;
import com.AleGla.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService service;
	

	// FIND ALL PERSONS
	@RequestMapping(value = "/all", produces = {"application/json"}, method = RequestMethod.GET)
	public String allPersons() throws JsonProcessingException {
		return PersonResponse.ResponseFindAll(service);
	}

	// FIND PERSON BY ID
	@RequestMapping(value = "/search/{id}", produces = {"application/json"}, method = RequestMethod.GET)
	public String findPersonById(@PathVariable("id") Integer id) throws JsonProcessingException {
		Optional<Person> person = service.searchPerson(new PersonRequest(id));

		return PersonResponse.ResponseFindPerson(person);
	}

	// ADD NEW PERSON
	@RequestMapping(value = "/new" , produces = {"application/json"}, method = RequestMethod.POST)
	public String addPerson(@RequestBody Person person) throws JsonProcessingException {

		return PersonResponse.responseAddPerson(person, service);
	}

	// MODIFY PERSON
	@RequestMapping(value = "/modify", produces = {"application/json"}, method = RequestMethod.PUT)
	public String modifyPerson(@RequestBody PersonModify newPerson) throws JsonProcessingException {
		Optional<Person> oldPerson = service.searchPerson(newPerson);

		return PersonResponse.ResponseUpdatePerson(oldPerson, newPerson, service);
	}

	// DELETE PERSON
	@RequestMapping(value = "/delete", produces = {"application/json"}, method = RequestMethod.DELETE)
	public String deletePerson(@RequestBody PersonRequest personReq) throws JsonProcessingException {

		return PersonResponse.responseDeletePerson(personReq.getId(), service);
	}
}
