package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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

	public Integer getFk_AnimalGroup() {
		return fk_AnimalGroup;
	}

	public void setFk_AnimalGroup(Integer fk_AnimalGroup) {
		this.fk_AnimalGroup = fk_AnimalGroup;
	}

	@Column(name="animalNumber")
	private String animalNumber;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="colour")
	private String colour;
	
	@Column(name="breed")
	private String breed;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name="fk_AnimalGroup")
	private Integer fk_AnimalGroup;
	
	public Animal() {
	}
}
