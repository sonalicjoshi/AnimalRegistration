package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AnimalTO;
import com.example.demo.service.AnimalBM;

@RestController
@RequestMapping(value="/animal")
public class AnimalRestController {
	@Autowired
	AnimalBM animalBM;
	
	@Autowired
	AnimalTO animalTo;
   
	@RequestMapping(value="/register-animal", method=RequestMethod.POST)
	public void registerAnimal(@RequestBody AnimalTO animalTO) {
		animalBM.registerAnimal(animalTO);
	}
	
	@RequestMapping(value="/byAnimalId/{animal-id}")
	public AnimalTO getAnimal(@PathVariable("animal-id") Integer animalId){
		return animalBM.getAnimal(animalId);
	}
	
	@RequestMapping(value="/get-animal-details/{animal-number}")
	public AnimalTO getAnimal(@PathVariable("animal-number") String animalNumber){
		return animalBM.getAnimalByAnimalNumber(animalNumber);
	}
	
	@RequestMapping(value="/byAnimalGroupId/{animal-group-id}")
	public List<AnimalTO> getByAnimalGroupId(@PathVariable("animal-group-id") Integer animalGroupId){
		return animalBM.getByAnimalGroupId(animalGroupId).stream().map(AnimalTO::map).collect(Collectors.toList());
	}

}
