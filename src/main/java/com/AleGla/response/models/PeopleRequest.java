package com.AleGla.response.models;


public class PeopleRequest {

	
	private Integer id;
	private String lastName;
	private String DNI;
	
	public PeopleRequest() {}
	

	public PeopleRequest(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
}
