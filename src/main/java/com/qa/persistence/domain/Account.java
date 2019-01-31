package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	private String accNumber;

	public Account() {
		firstName = "james";
		lastName = "jamerson";
		accNumber = "1";
		                                                                                                                                                                                                                                                                                                                                                                                                                                         
	}
	
	public Account(String firstName,String lastName, String accNumber) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setAccNumber(accNumber);
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	

}
