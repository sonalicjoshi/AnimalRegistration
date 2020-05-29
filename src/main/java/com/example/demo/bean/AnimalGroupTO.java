package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class AnimalGroupTO {
	
	private Integer id;
	private String animalGroupNumber;
	private String type;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnimalGroupNumber() {
		return animalGroupNumber;
	}
	public void setAnimalGroupNumber(String animalGroupNumber) {
		this.animalGroupNumber = animalGroupNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	

}
