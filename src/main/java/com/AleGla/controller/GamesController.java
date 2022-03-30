package com.AleGla.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GamesController {

	
	@GetMapping
	public String allGames() {
		return "{Greeting : Hi Dude, Welcome to Games Repository}";
	}

}
