package com.AleGla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AleGla.models.Person;

public interface PersonDAO extends JpaRepository<Person, Integer>{

	
}
