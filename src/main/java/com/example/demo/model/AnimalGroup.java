package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="animal_group")
public class AnimalGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="animalGroupNumber")
	private String animalGroupNumber;

	
	@Column(name="type")
	private String agType;
	
	public AnimalGroup() {
		this.agType="O-FARM";
	}
	
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

	public String getAgType() {
		return agType;
	}

	public void setAgType(String agType) {
		this.agType = agType;
	}
	
}
