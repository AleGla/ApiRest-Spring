package com.AleGla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AleGla.dao.GameDAO;
import com.AleGla.models.Game;
import com.AleGla.models.GameModify;
import com.AleGla.models.GameRequest;

@Component
public class GameService {

	@Autowired
	private GameDAO gameDAO;

	public void savePerson(Game g) {
		gameDAO.save(g);
	}

	public void updatePerson(Game g) {
		gameDAO.save(g);
	}

	public void deletePerson(Game g) {
		gameDAO.delete(g);
	}

	public List<Game> listPersons() {
		return gameDAO.findAll();
	}

	public Optional<Game> searchPerson(GameRequest g) {
		return gameDAO.findById(g.getId());
	}

	public Optional<Game> searchPerson(GameModify g) {
		return gameDAO.findById(g.getIdGame());
	}

}
