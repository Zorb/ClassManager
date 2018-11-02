package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String trainerName;
	private String classNumber;

	public Classroom() {

	}

	public Classroom(String trainerName, String classNumber) {
		this.trainerName = trainerName;
		this.classNumber = classNumber;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}