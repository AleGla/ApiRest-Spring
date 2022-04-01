package com.AleGla.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.AleGla.dao.GameDAO;
import com.AleGla.models.Game;
import com.AleGla.models.GameModify;
import com.AleGla.models.GameRequest;
import com.AleGla.response.GameResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("game")
public class GamesController {

	@Autowired
	private GameDAO gameDAO;	
	

	
	//FIND ALL GAMES
	@RequestMapping(value = "/all", produces = {"application/json"}, method = RequestMethod.GET)
	public String allPeople() throws JsonProcessingException {			 		  
		 
		 return GameResponse.ResponseFind(gameDAO);
	}
	
	//FIND GAME BY ID
	@RequestMapping(value = "/search", produces = {"application/json"}, method = RequestMethod.GET)
	public String findPersonById(@RequestBody GameRequest gameReq) throws JsonProcessingException {				
		Optional<Game> game = gameDAO.findById(gameReq.getId());			
		
		return GameResponse.ResponseFind(game);
	}
	
	//ADD NEW GAME 
	@RequestMapping(value = "/new" , produces = {"application/json"}, method = RequestMethod.POST)
	public String addGame(@RequestBody Game game) throws JsonProcessingException {
		
		return GameResponse.responseAddGame(game, gameDAO);	
	}
	
	
	//MODIFY GAME
	@RequestMapping(value = "/modify", produces = {"application/json"}, method = RequestMethod.PUT)
	public String modifyGame(@RequestBody GameModify newGame) throws JsonProcessingException {
		Optional<Game> oldGame = gameDAO.findById(newGame.getIdGame());
		
		return GameResponse.ResponseUpdate(oldGame, newGame, gameDAO);
	}
	
	//DELETE GAME
	@RequestMapping(value = "/delete", produces = {"application/json"}, method = RequestMethod.DELETE)
	public String deleteGame(@RequestBody GameRequest gameReq) throws JsonProcessingException {
		
		return GameResponse.responseDeleteGame(gameReq.getId(), gameDAO);
	}

}
