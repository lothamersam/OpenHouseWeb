package com.openhouse.services.enums;

public enum AboutSectionType {
	ABOUT_SECTION("aboutSection"),
	ADDRESS_SECTION("addressSection"),
	AUDITION_SECTION("auditionSection"),
	PRODUCTION_SECTION("productionSection"),
	DONATE_SECTION("donateSection");

	private String sectionType;
	
	AboutSectionType(String sectionType) {
		this.sectionType = sectionType;
	}
	
	public String getSectionType() {
		return this.sectionType;
	}
}
