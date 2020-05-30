package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Animal;

@Repository
public interface AnimalDAO extends JpaRepository<Animal, Integer> {
	
	public Optional<Animal> findByAnimalNumber(String animalNumber);
	
	@Query("SELECT a FROM Animal a WHERE a.fk_AnimalGroup = :animalGroupId")
	List<Animal> findByfk__AnimalGroup(@Param("animalGroupId")Integer fk_AnimalGroup);

}

