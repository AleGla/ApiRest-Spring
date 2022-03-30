package com.AleGla.utils;

import com.AleGla.models.People;

public class StringToUpperCase {

	public static void toUpperCase(People people) {		
		people.setName(people.getName().toUpperCase());
		people.setLastName(people.getLastName().toUpperCase());		
		people.setGender(Character.toUpperCase(people.getGender()));
		people.setNationality(people.getNationality().toUpperCase());		
		withoutSpaces(people);
	}
	
	private static void withoutSpaces(People people) {
		people.setDNI(people.getDNI().replace(" ",""));
	}
}
