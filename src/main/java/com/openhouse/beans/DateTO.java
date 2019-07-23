package com.openhouse.beans;

import com.openhouse.services.enums.DateType;

public class DateTO {
	private int id;
	private String date;
	private String startTime;
	private String endTime;
	private String location;
	private String information;
	private DateType type;
	
	public DateTO() {
	
	}
	
	public DateTO(int id, String date, String startTime, String endTime, String location, String information) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
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
	
	public void setDate(String startTime) {
		this.date = startTime;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void getEndTime(String time) {
		this.time = time;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getType() {
		return type.getType();
	}

	public void setType(String type) {
		this.type = DateType.getTypeFromKey(type);
	}
	
	public void setType(DateType type) {
		this.type = type;
	}
}
