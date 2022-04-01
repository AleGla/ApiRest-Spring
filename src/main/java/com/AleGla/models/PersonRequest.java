package com.AleGla.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequest {

	@JsonProperty("id")
	private Integer id;	
	
	
	public PersonRequest() {}
	

	public PersonRequest(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

			
}
