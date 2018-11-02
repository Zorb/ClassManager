package com.cognizant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "tr_id")
	private Long id;
	private String firstName;
	private String secondName;
	private String piiNumber;
	@Column(name = "class_id")
	private Long classid;

	public Trainee() {

	}

	public Trainee(String firstName, String secondName, String piiNumber) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.piiNumber = piiNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPiiNumber() {
		return piiNumber;
	}

	public void setPiiNumber(String piiNumber) {
		this.piiNumber = piiNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassroom() {
		return classid;
	}

	public void setClassroom(Long classroom) {
		this.classid = classroom;
	}

}