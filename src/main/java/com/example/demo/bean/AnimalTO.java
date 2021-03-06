package com.example.demo.bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Animal;
import com.example.demo.model.AnimalGroup;

@Component
public class AnimalTO {
	private Integer id;
	private String animalNumber;
	private String sex;
	private String colour;
	private String breed;
	private LocalDate dateOfBirth;
	private Integer animalGroupId;
	private String animalGroupNumber;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnimalNumber() {
		return animalNumber;
	}
	public void setAnimalNumber(String animalNumber) {
		this.animalNumber = animalNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}
	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}
	
	public Integer getAnimalGroupId() {
		return animalGroupId;
	}
	public void setAnimalGroupId(Integer animalGroupId) {
		this.animalGroupId = animalGroupId;
	}
	
	public static AnimalTO map(Animal animal) {
		AnimalTO animalTO = new AnimalTO();
		animalTO.setId(animal.getId());
		animalTO.setAnimalNumber(animal.getAnimalNumber());
		animalTO.setBreed(animal.getBreed());
		animalTO.setColour(animal.getColour());
		animalTO.setDateOfBirth(animal.getDateOfBirth());
		animalTO.setSex(animal.getSex());
		animalTO.setAnimalGroupId(animal.getFk_AnimalGroup());
		animalTO.setAnimalGroupNumber(animal.getFk_AnimalGroup().toString());
		return animalTO;
	}
}
