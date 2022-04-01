package com.AleGla.response;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import com.AleGla.exception.CustomException;
import com.AleGla.models.Person;
import com.AleGla.models.PersonModify;
import com.AleGla.models.PersonRequest;
import com.AleGla.service.PersonService;
import com.AleGla.utils.BadResponse;
import com.AleGla.utils.ModifyValues;
import com.AleGla.utils.StringToUpperCase;
import com.AleGla.utils.TransformToJson;
import com.fasterxml.jackson.core.JsonProcessingException;


public class PersonResponse {

	// FIND ALL PERSONS
	public static String ResponseFindAll(PersonService service) throws JsonProcessingException {
		List<Person> listPersons = service.listPersons();	
		JSONObject json = new JSONObject();
		
		//// if to be search in database and it is empty ///////////////////////////////////////////////////////
		if (listPersons.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().EmptyDataBasePerson());
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		json.put("persons", listPersons);
		json.put("status", HttpStatus.OK.value());
		json.put("message", "List of people was found successful");
		json.put("function", "listAllPeople");		
		LogManager.getLogger().info("Function = listAllPeople | Response -> " + json);
		return json.toString();
	}

	// FIND PERSON BY ID
	public static String ResponseFindPerson(Optional<Person> person) throws JsonProcessingException {
		JSONObject json = new JSONObject();

		//// if search in database and i didn't found any game/////////////////////////////////////////////
		if (person.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionPerson());
		///////////////////////////////////////////////////////////////////////////////////////////////////

		json.put("person", TransformToJson.toJsonPerson(person));
		json.put("status", HttpStatus.OK.value());
		json.put("message", "The Person was found successful");
		json.put("function", "searchPerson");		
		LogManager.getLogger().info("Function = searchPerson | Response -> " + json);
		return json.toString();
	}

	// MODIFY PERSON
	public static String ResponseUpdatePerson(Optional<Person> person, PersonModify updatePerson, PersonService service) throws JsonProcessingException {
		JSONObject json = new JSONObject();
		
		//// if the person search to delete, wasn't found in database -- EXCEPTION ////////////////////////
		if (person.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionPerson());
		///////////////////////////////////////////////////////////////////////////////////////////////////
			
		Person oldPerson = person.get();
		ModifyValues.setNewValuesPerson(oldPerson, updatePerson);
		service.savePerson(oldPerson);
		json.put("personOldData", TransformToJson.toJsonObject(oldPerson));
		json.put("status", HttpStatus.OK.value());
		json.put("message", "The Person was updated successful");
		json.put("function", "modifyPerson");		
		LogManager.getLogger().info("Function = modifyPerson | Response -> " + json);
		return json.toString();
	}

	// ADD NEW PERSON
	public static String responseAddPerson(Person person, PersonService service) throws JsonProcessingException {
		JSONObject json = new JSONObject();
		
		////Check if some value is null -- EXCEPTION ////////////////////////////////////////////////////////////
		if(person.getAge() == null || person.getDNI() == null || person.getGender() == '\u0000' || person.getLastName() == null || person.getNationality() == null) return BadResponse.exceptionResponse(json, HttpStatus.BAD_REQUEST, new CustomException().isNullSomeAttributePerson());
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		StringToUpperCase.toUpperCase(person);
		service.savePerson(person);
		json.put("person", TransformToJson.toJsonObject(person));
		json.put("HttpStatus", HttpStatus.OK.value());
		json.put("message", "The Person was add successful");
		json.put("function", "newPerson");
		LogManager.getLogger().info("Function = newPerson | Response -> " + json);
		return json.toString();
	}

	// DELETE PERSON
	public static String responseDeletePerson(Integer id, PersonService service) throws JsonProcessingException {
		PersonRequest req = new PersonRequest();
		req.setId(id);
		Optional<Person> personToDelete = service.searchPerson(req);
		JSONObject json = new JSONObject();
		
		///// if the person search to delete, wasn't found in database -- EXCEPTION ///////////////////////////////
		if (personToDelete.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionPerson());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		service.deletePerson(personToDelete.get());
		json.put("person", TransformToJson.toJsonPerson(personToDelete));
		json.put("HttpStatus", HttpStatus.OK.value());
		json.put("message", "The Person was delete successful");
		json.put("function", "deletePerson");
		LogManager.getLogger().info("Function = deletePerson | Response -> " + json);
		return json.toString();
	}
	

}
