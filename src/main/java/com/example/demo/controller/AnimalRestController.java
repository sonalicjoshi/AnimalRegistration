package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AnimalTO;
import com.example.demo.service.AnimalBM;

@RestController
public class AnimalRestController {
	@Autowired
	AnimalBM animalBM;
	
	@Autowired
	AnimalTO animalTo;
   
	@RequestMapping(value="/register-animal", method=RequestMethod.POST)
	public void registerAnimal(@RequestBody AnimalTO animalTO) {
		animalBM.registerAnimal(animalTO);
	}
	
	@RequestMapping(value="/animal/{animal-id}")
	public AnimalTO getAnimal(@PathVariable("animal-id") Integer animalId){
		return AnimalTO.map(animalBM.getAnimal(animalId).orElseThrow(()-> new IllegalArgumentException("Animal id not found")));
	}

}
