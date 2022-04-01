package com.AleGla.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameRequest {

	@JsonProperty("id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
