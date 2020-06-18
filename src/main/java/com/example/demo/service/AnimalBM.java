package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.bean.AnimalGroupTO;
import com.example.demo.bean.AnimalTO;
import com.example.demo.dao.AnimalDAO;
import com.example.demo.model.Animal;


@Service
public class AnimalBM {
	@Autowired
	Animal animal;

	
	@Autowired
	AnimalDAO animalDao;
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	@Transactional
	public void registerAnimal(AnimalTO animalTO) {
		Optional<Animal> existingAnimal = animalDao.findByAnimalNumber(animalTO.getAnimalNumber());
		if(existingAnimal.isPresent()) {
			 throw new IllegalArgumentException("Animal already present");
		} else {
			animal.setAnimalNumber(animalTO.getAnimalNumber());
			animal.setBreed(animalTO.getBreed());
			animal.setColour(animalTO.getColour());
			animal.setDateOfBirth(animalTO.getDateOfBirth());
			animal.setSex(animalTO.getSex());
			Integer animalGroupId = getAnimalGroupId(animalTO.getAnimalGroupNumber());
			animal.setFk_AnimalGroup(animalGroupId);
			animalDao.save(animal);
		}
	}
	

	/**
	 * gets animal group Id for given animal group number
	 * @param animalGroupNumber
	 */
	private Integer getAnimalGroupId(String animalGroupNumber) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		String uri = "http://animal-group-registration/animalGroup/" + animalGroupNumber;
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri).build();
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<AnimalGroupTO> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AnimalGroupTO.class);
		return responseEntity.getBody().getId();		
	}
	
	/**
	 * gets animal group Number for given animal group Id
	 * @param animalGroupId
	 */
	private String getAnimalGroupNumber(Integer animalGroupId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		String uri = "http://animal-group-registration/animalGroup/get-animal-group-by-id/" + animalGroupId;
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri).build();
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<AnimalGroupTO> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, AnimalGroupTO.class);
		return responseEntity.getBody().getAnimalGroupNumber();		
	}

	public AnimalTO getAnimal(Integer animalId) {
		Optional<Animal> animal = animalDao.findById(animalId);
		if(animal.isPresent()) {
			AnimalTO animalTO =  AnimalTO.map(animal.get());
			animalTO.setAnimalGroupNumber(getAnimalGroupNumber(animalTO.getAnimalGroupId()));
			return animalTO;
		} else {
			 throw new IllegalArgumentException("Animal id not found");
		}
	}
	
	public List<Animal> getByAnimalGroupId(Integer animalGroupId) {
		return animalDao.findByfk__AnimalGroup(animalGroupId);
	}


	public AnimalTO getAnimalByAnimalNumber(String animalNumber) {
		Optional<Animal> animal = animalDao.findByAnimalNumber(animalNumber);
		if(animal.isPresent()) {
			AnimalTO animalTO =  AnimalTO.map(animal.get());
			animalTO.setAnimalGroupNumber(getAnimalGroupNumber(animalTO.getAnimalGroupId()));
			return animalTO;
		} else {
			 throw new IllegalArgumentException("Animal Number not found");
		}
	}
	
}
