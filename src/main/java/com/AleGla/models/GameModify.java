package com.AleGla.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameModify {

		@JsonProperty("id")
		private Integer idGame;
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("price")
		private Integer price;
		
		@JsonProperty("gender")
		private String gender;
		

		public Integer getIdGame() {
			return idGame;
		}

		public void setIdGame(Integer idGame) {
			this.idGame = idGame;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		
		
	}


