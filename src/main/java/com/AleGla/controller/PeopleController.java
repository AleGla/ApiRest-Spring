package com.AleGla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AleGla.dao.PeopleDAO;
import com.AleGla.models.People;
import com.AleGla.response.models.PeopleRequest;
import com.AleGla.response.models.PeopleResponse;
import com.AleGla.utils.StringToUpperCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("people")
public class PeopleController {
	
		
	@Autowired
	private PeopleDAO peopleDAO;
	
	@Autowired
	private ObjectMapper mapper;
	

	
	//FIND ALL PEOPLE
	@GetMapping()
	public String allPeople() throws JsonProcessingException {
		 List<People> people = peopleDAO.findAll();		 
		  
		 
		 return PeopleResponse.ResponseFind(mapper, people);
	}
	
	//FIND PERSON BY ID
	@GetMapping(value = "/{idPerson}")
	public String findPersonById(@PathVariable("idPerson") Integer id) throws JsonProcessingException {
		PeopleRequest request = new PeopleRequest();
		request.setId(id);		
		Optional<People> person = peopleDAO.findById(request.getId());			
		
		return PeopleResponse.ResponseFind(mapper, person);
	}
	
	//ADD NEW PERSON 
	@PostMapping("/newPerson")
	public String addPerson(@RequestBody People people) throws JsonProcessingException {
		
		StringToUpperCase.toUpperCase(people);
		People newPerson = peopleDAO.save(people);
		Map<String, Object> response = new HashMap<String, Object>();
		 response.put("person", newPerson);
		 response.put("HttpStatus", HttpStatus.ACCEPTED.value());
		 response.put("message", "The Person was add successful");
		
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response).toString();	
	}
	
	
	//MODIFY PERSON
	@PutMapping("/modifyPerson")
	public String modifyPerson(@RequestBody People newPerson) throws JsonProcessingException {
		Optional<People> oldPerson = peopleDAO.findById(newPerson.getId());
		
		return PeopleResponse.ResponseUpdate(mapper, oldPerson, newPerson);
	}
}
