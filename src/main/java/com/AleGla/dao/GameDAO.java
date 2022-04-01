package com.AleGla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AleGla.models.Game;

public interface GameDAO extends JpaRepository<Game, Integer>{

}
