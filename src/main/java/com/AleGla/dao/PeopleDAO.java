package com.AleGla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AleGla.models.People;

public interface PeopleDAO extends JpaRepository<People, Integer>{

}
