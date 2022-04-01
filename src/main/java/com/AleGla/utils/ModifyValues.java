package com.AleGla.utils;

import com.AleGla.models.Game;
import com.AleGla.models.GameModify;
import com.AleGla.models.Person;
import com.AleGla.models.PersonModify;

public class ModifyValues {

	public static void setNewValuesPerson(Person p, PersonModify pMO) {
		if(pMO.getName() != null) p.setName(pMO.getName().toUpperCase());
		if(pMO.getLastName() != null) p.setLastName(pMO.getLastName().toUpperCase());
		if(pMO.getNationality() != null) p.setNationality(pMO.getNationality().toUpperCase());
		if(pMO.getDNI() != null) p.setDNI(pMO.getDNI().toUpperCase());
		if(!(pMO.getGender() != ' ')) p.setGender(Character.toUpperCase(pMO.getGender()));
		if(pMO.getAge() != null) p.setAge(pMO.getAge());		
	}
	
	public static void setNewValuesGame(Game g, GameModify gMO) {
		if(!gMO.getName().isEmpty()) g.setName(gMO.getName().toUpperCase());
		if(gMO.getPrice() != 0) g.setPrice(gMO.getPrice());
		if(!gMO.getGender().isEmpty()) g.setGender(gMO.getGender().toUpperCase());		
	}
	
}
