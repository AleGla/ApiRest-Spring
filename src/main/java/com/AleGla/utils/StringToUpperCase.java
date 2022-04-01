package com.AleGla.utils;

import com.AleGla.models.Game;
import com.AleGla.models.Person;

public class StringToUpperCase {

	public static void toUpperCase(Person people) {	
		if(!people.getName().isEmpty()) people.setName(people.getName().toUpperCase());
		if(!people.getLastName().isEmpty()) people.setLastName(people.getLastName().toUpperCase());		
		if(people.getGender() != ' ') people.setGender(Character.toUpperCase(people.getGender()));
		if(!people.getNationality().isEmpty()) people.setNationality(people.getNationality().toUpperCase());		
		if(!people.getDNI().isEmpty()) withoutSpaces(people);		
	}
	
	private static void withoutSpaces(Person people) {
		people.setDNI(people.getDNI().replace(" ",""));
	}
	
	public static void toUpperCase(Game game) {	
		if(!game.getName().isEmpty()) game.setName(game.getName().toUpperCase());				
		if(game.getGender().isEmpty()) game.setGender(game.getGender().toUpperCase());
	}
	
	
}
