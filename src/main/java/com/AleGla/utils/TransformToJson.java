package com.AleGla.utils;

import java.util.Optional;

import org.json.JSONObject;

import com.AleGla.models.Game;
import com.AleGla.models.Person;

public class TransformToJson {

	public static JSONObject toJsonGame(Optional<Game> game) {
		JSONObject json = new JSONObject();
		json.put("gender", game.get().getGender());
		json.put("price", game.get().getPrice());
		json.put("name", game.get().getName());
		json.put("id", game.get().getIdGame());
		return json;
	}

	public static JSONObject toJsonPerson(Optional<Person> person) {
		JSONObject json = new JSONObject();
		if(person.get().getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");	
		json.put("nationality", person.get().getNationality());
		json.put("dni", person.get().getDNI());
		json.put("age", person.get().getAge());
		json.put("lastName", person.get().getLastName());
		json.put("name", person.get().getName());
		json.put("id", person.get().getId());
		return json;
	}

	public static JSONObject toJsonObject(Person person) {
		JSONObject json = new JSONObject();
		if(person.getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");	
		json.put("nationality", person.getNationality());
		json.put("dni", person.getDNI());
		json.put("age", person.getAge());
		json.put("lastName", person.getLastName());
		json.put("name", person.getName());
		json.put("id", person.getId());
		return json;
	}

	public static JSONObject toJsonObject(Game game) {
		JSONObject json = new JSONObject();
		json.put("id", game.getIdGame());
		json.put("name", game.getName());		
		json.put("price", game.getPrice());
		json.put("gender", game.getGender());		
		return json;
	}
}
