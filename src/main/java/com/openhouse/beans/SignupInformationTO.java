package com.openhouse.beans;

public class SignupInformationTO {
	private int id;
	private String firstName;
	private String lastName;
	private String pronouns;
	private String date;
	private String email;
	private String phoneNumber;
	
	public SignupInformationTO() {}
	
	public SignupInformationTO(int id, 
			String firstName, 
			String lastName, 
			String pronouns, 
			String date, 
			String email, 
			String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pronouns = pronouns.toUpperCase();
		this.date = date;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getPronouns() {
		return pronouns.toUpperCase();
	}
	
	public void setPronouns(String pronouns) {
		this.pronouns = pronouns.toUpperCase();
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	
	
}
