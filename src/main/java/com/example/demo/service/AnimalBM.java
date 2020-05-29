package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.AnimalTO;
import com.example.demo.dao.AnimalDAO;
import com.example.demo.dao.AnimalGroupDAO;
import com.example.demo.model.Animal;
import com.example.demo.model.AnimalGroup;

@Service
public class AnimalBM {
	@Autowired
	Animal animal;
	
	@Autowired
	AnimalGroup animalGroup;
	
	@Autowired
	AnimalDAO animalDao;
	
	@Autowired
	AnimalGroupDAO animalGroupDao;
	
	@Transactional
	public void registerAnimal(AnimalTO animalTO) {
		animal.setAnimalNumber(animalTO.getAnimalNumber());
		animal.setBreed(animalTO.getBreed());
		animal.setColour(animalTO.getColour());
		animal.setDateOfBirth(animalTO.getDateOfBirth());
		animal.setSex(animalTO.getSex());
		animalGroup = animalGroupDao.findByAnimalGroupNumber(animalTO.getAnimalGroup().getAnimalGroupNumber());
		animal.setFk_AnimalGroup(animalGroup);
		animalDao.save(animal);		
	}

	public Optional<Animal> getAnimal(Integer animalId) {
		return animalDao.findById(animalId);
	}
	
	public Optional<Animal> getAnimalByNumber(String animalNumber) {
		return animalDao.findByAnimalNumber(animalNumber);
	}

}
