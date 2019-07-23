package com.openhouse.services.enums;

public enum DateType {
	AUDITION("audition"),
	PRODUCTION("production");

	private final String type;
	
	DateType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public static DateType getTypeFromKey(String key) {	
		for(DateType dateType : DateType.values()) {
			if(key.equals(dateType.type)) {
				return dateType;
			}
		}
		
		return null;
	}
}
