package com.AleGla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AleGla.dao.PersonDAO;
import com.AleGla.models.Person;
import com.AleGla.models.PersonModify;
import com.AleGla.models.PersonRequest;

@Component
public class PersonService {

	@Autowired
	private PersonDAO personDAO;

	public void savePerson(Person p) {
		personDAO.save(p);
	}

	public void updatePerson(Person p) {
		personDAO.save(p);
	}

	public void deletePerson(Person p) {
		personDAO.delete(p);
	}

	public List<Person> listPersons() {
		return personDAO.findAll();
	}

	public Optional<Person> searchPerson(PersonRequest p) {
		return personDAO.findById(p.getId());
	}

	public Optional<Person> searchPerson(PersonModify p) {
		return personDAO.findById(p.getId());
	}

}
