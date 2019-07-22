package com.openhouse.beans;

public class SignupInformationTO {
	private String firstName;
	private String lastName;
	private String pronouns;
	private String date;
	private String email;
	
	public SignupInformationTO() {}
	
	public SignupInformationTO(String firstName, String lastName, String pronouns, String date, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pronouns = pronouns;
		this.date = date;
		this.email = email;
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
		return pronouns;
	}
	
	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
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
}
