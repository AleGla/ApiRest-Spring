package com.AleGla.response;


import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import com.AleGla.dao.GameDAO;
import com.AleGla.exception.CustomException;
import com.AleGla.models.Game;
import com.AleGla.models.GameModify;
import com.AleGla.models.GameRequest;
import com.AleGla.utils.BadResponse;
import com.AleGla.utils.ModifyValues;
import com.AleGla.utils.StringToUpperCase;
import com.AleGla.utils.TransformToJson;
import com.fasterxml.jackson.core.JsonProcessingException;



public class GameResponse {

	// FIND ALL GAMES
	public static String ResponseFind(GameDAO gameDAO) throws JsonProcessingException{
		List<Game> games = gameDAO.findAll();	
		JSONObject json = new JSONObject();
		
		//// if to be search in database and it is empty /////////////////////////////////////////////////
		if (games.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().EmptyDataBaseGame());
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		json.put("games", games);
		json.put("status", HttpStatus.OK.value());
		json.put("message", "List of games was found successful");
		json.put("function", "listAllGames");
		LogManager.getLogger().info("Function = listAllGames | Response -> " + json);
		return json.toString();
	}
	
	

	// FIND GAME BY ID
	public static String ResponseFind(Optional<Game> game) throws JsonProcessingException {
		JSONObject json = new JSONObject();
				
		 //// if search in database and i didn't found any game///////////////////////////////////////////
		if (game.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionGame());
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		json.put("game", TransformToJson.toJsonGame(game));
		json.put("status", HttpStatus.OK.value());
		json.put("message", "The game was found successful");	
		json.put("function", "searchGame");
		LogManager.getLogger().info("Function = searchGame | Response -> " + json);
		return json.toString();
	}
	
	

	// MODIFY GAME
	public static String ResponseUpdate(Optional<Game> game, GameModify updateGame, GameDAO gameDAO) throws JsonProcessingException{
		JSONObject json = new JSONObject();
		
		//// if the game search to delete, wasn't found in database -- EXCEPTION ////////////////////////
		if (game.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionGame());
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		Game oldPerson = game.get();
		ModifyValues.setNewValuesGame(oldPerson, updateGame);		
		gameDAO.save(oldPerson);
		json.put("gameDataModificated", TransformToJson.toJsonGame(game));
		json.put("status", HttpStatus.OK.value());
		json.put("message", "The game was updated successful");
		json.put("function", "modifyGame");
		LogManager.getLogger().info("Function = modifyGame | Response -> " + json);
		return json.toString();
	}
	
	

	// ADD NEW GAME
	public static String responseAddGame(Game game, GameDAO gameDAO) throws JsonProcessingException {		
		JSONObject json = new JSONObject();
		
		////Check if some value is null -- EXCEPTION ////////////////////////////////////////////////////////////
		if(game.getName() == null || game.getGender() == null || game.getPrice() == null) return BadResponse.exceptionResponse(json, HttpStatus.BAD_REQUEST, new CustomException().isNullSomeAttributeGame());
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		StringToUpperCase.toUpperCase(game);
		Game newGame = gameDAO.save(game);
		json.put("game", TransformToJson.toJsonObject(newGame));
		json.put("HttpStatus", HttpStatus.OK.value());
		json.put("message", "The game was add successful");
		json.put("function", "newGame");
		LogManager.getLogger().info("Function = newGame | Response -> " + json);
		return json.toString();
	}
	
	

	// DELETE GAME
	public static String responseDeleteGame(Integer id, GameDAO gameDAO) throws JsonProcessingException {
		GameRequest req = new GameRequest();
		req.setId(id);
		Optional<Game> gameToDelete = gameDAO.findById(req.getId());
		JSONObject json = new JSONObject();
		
		///// if the game search to delete, wasn't found in database -- EXCEPTION ///////////////////////////////
		if (gameToDelete.isEmpty()) return BadResponse.exceptionResponse(json, HttpStatus.NOT_FOUND, new CustomException().notFoundExceptionGame());
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		gameDAO.deleteById(req.getId());
		json.put("game", TransformToJson.toJsonGame(gameToDelete));
		json.put("HttpStatus", HttpStatus.OK.value());
		json.put("message", "The game was delete successful");
		json.put("function", "deleteGame");
		LogManager.getLogger().info("Function = deleteGame | Response -> " + json);
		return json.toString();
	}
	
	

}
