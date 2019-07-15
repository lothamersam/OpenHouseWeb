package com.openhouse.services.enums;

public enum AboutSectionType {
	ABOUT_SECTION("aboutSection", "introduction"),
	ADDRESS_SECTION("addressSection", "location"),
	AUDITION_SECTION("auditionSection", "audition"),
	PRODUCTION_SECTION("productionSection", "production"),
	DONATE_SECTION("donateSection", "donation");

	private String sectionType;
	private String divKey;
	
	AboutSectionType(String sectionType, String divKey) {
		this.sectionType = sectionType;
		this.divKey = divKey;
	}
	
	public String getSectionType() {
		return this.sectionType;
	}
	
	public String getDivKey() {
		return this.divKey;
	}
	
	public static String getTypeFromKey(String key) {	
		for(AboutSectionType type : AboutSectionType.values()) {
			if(key.equals(type.getDivKey())) {
				return type.getSectionType();
			}
		}
		
		return null;
	}
}
