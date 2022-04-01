package com.AleGla.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_game")
	private Integer idGame;
	
	@Column(name="name")
	@JsonProperty("name")
	private String name;
	
	@Column(name="price")
	@JsonProperty("price")
	private Integer price;
	
	@Column(name="gender")
	@JsonProperty("gender")
	private String gender;
	
	public Game() {}

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
