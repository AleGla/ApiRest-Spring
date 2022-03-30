package com.AleGla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AleGla.dao.PeopleDAO;
import com.AleGla.models.People;
import com.AleGla.response.models.PeopleRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
@RequestMapping("people")
public class PeopleController {
	
	@Autowired
	private PeopleDAO peopleDAO;
	
	@Autowired
	private ObjectMapper mapper;
	

	@GetMapping()
	public String allPeople() throws JsonProcessingException {
		 List<People> people = peopleDAO.findAll();

		 Map<String, Object> response = new HashMap<String, Object>();
		 response.put("person", people);
		 response.put("status", HttpStatus.ACCEPTED.value());
		 response.put("message", "List of people");
		 
		 String	json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			return json;		 
	}
	
	@GetMapping(value = "{idPerson}")
	public String addPerson(@PathVariable("idPerson") Integer id) throws JsonProcessingException {
		PeopleRequest person = new PeopleRequest();
		person.setId(id);
		//PeopleRequest person = new Gson().fromJson(payload, PeopleRequest.class);
		
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(peopleDAO.findById(person.getId())).toString();
	}
}
