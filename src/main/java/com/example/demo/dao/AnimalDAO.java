package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Animal;

@Repository
public interface AnimalDAO extends JpaRepository<Animal, Integer> {
	
	public Optional<Animal> findByAnimalNumber(String animalNumber);

}

