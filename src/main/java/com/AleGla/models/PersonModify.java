package com.AleGla.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PersonModify implements Serializable{

	
	private static final long serialVersionUID = 4367936426088932702L;
	

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")	
	private String name;
	
	@JsonProperty("lastName")	
	private String lastName;
	
	@JsonProperty("age")
	private Integer age;
	
	@JsonProperty("dni")
	private String DNI;
	
	@JsonProperty("nationality")
	private String Nationality;
	
	@JsonProperty("gender")
	private char gender;
	
	public PersonModify() {}
	
	public PersonModify(String name, String lastName, Integer age, String DNI, String Nationality, char gender) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.DNI =DNI;
		this.Nationality = Nationality;
		this.gender = gender;
	}
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		this.Nationality = nationality;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
