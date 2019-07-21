package com.openhouse.beans;

public class AuditionDateTO {
	private int id;
	private String date;
	private String time;
	private String location;
	private String information;
	
	public AuditionDateTO() {
	
	}
	
	public AuditionDateTO(int id, String date, String time, String location, String information) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.location = location;
		this.information = information;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getInformation() {
		return information;
	}
	
	public void setInformation(String information) {
		this.information = information;
	}

}
