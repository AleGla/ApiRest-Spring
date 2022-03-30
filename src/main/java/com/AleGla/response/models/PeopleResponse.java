package com.AleGla.response.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;

import com.AleGla.dao.PeopleDAO;
import com.AleGla.exception.ApiException;
import com.AleGla.exception.CustomException;
import com.AleGla.models.People;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PeopleResponse {	

	

	public static String ResponseFind(ObjectMapper mapper, List<People> people) throws JsonProcessingException{
		Map<String, Object> response = new HashMap<String, Object>();
		if(people.isEmpty()) { //if i search in database and i didn't found somebody
			ApiException ex = new CustomException().isEmptyException();
			response.put("ErrorCode", ex.getCode());
			response.put("Status", HttpStatus.BAD_REQUEST.value());
			response.put("ErrorMessage", ex.getErrorMessage());
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
				LogManager.getLogger().info(json);
				return json;
		}		
		
		 response.put("person", people);
		 response.put("status", HttpStatus.ACCEPTED.value());
		 response.put("message", "List of people was found successful");		 
		 String	json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		 LogManager.getLogger().info(json);
		 return json;
	}
	
	public static String ResponseFind(ObjectMapper mapper, Optional<People> people) throws JsonProcessingException{
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(people.isEmpty()) { //if i search in database and i didn't found somebody
				ApiException ex = new CustomException().isEmptyException();
				response.put("ErrorCode", ex.getCode());
				response.put("Status", HttpStatus.BAD_REQUEST.value());
				response.put("ErrorMessage", ex.getErrorMessage());
				String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
				LogManager.getLogger().info(json);
				return json;
		}		 
		
		response.put("person", people);
		 response.put("status", HttpStatus.ACCEPTED.value());
		 response.put("message", "The Person was found successful");		 
		 String	json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		 LogManager.getLogger().info(json);
		 return json;
	}
	
	public static String ResponseUpdate(ObjectMapper mapper, Optional<People> people, People updatePerson) throws JsonProcessingException{
		Map<String, Object> response = new HashMap<String, Object>();		
		if(people.isEmpty()) {
			ApiException ex = new CustomException().isEmptyException();
			response.put("ErrorCode", ex.getCode());
			response.put("Status", HttpStatus.BAD_REQUEST.value());
			response.put("ErrorMessage", ex.getErrorMessage());
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			LogManager.getLogger().info(json);
			return json;
		}		
		 People oldPerson = people.get();
		 oldPerson.setName(updatePerson.getName().toUpperCase());
		 oldPerson.setLastName(updatePerson.getLastName().toUpperCase());
		 oldPerson.setNationality(updatePerson.getNationality().toUpperCase());
		 oldPerson.setDNI(updatePerson.getDNI().toUpperCase());
		 oldPerson.setGender(Character.toUpperCase(updatePerson.getGender()));
		 oldPerson.setAge(updatePerson.getAge());
		 
		 response.put("person", oldPerson);
		 response.put("status", HttpStatus.ACCEPTED.value());
		 response.put("message", "The Person was updated successful");		 
		 String	json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		 LogManager.getLogger().info(json);
		 return json;
	}
	
}
