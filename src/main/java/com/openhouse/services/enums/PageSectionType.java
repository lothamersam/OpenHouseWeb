package com.openhouse.services.enums;

public enum PageSectionType {
	ABOUT_SECTION("aboutSection", "introduction"),
	ADDRESS_SECTION("addressSection", "location"),
	AUDITION_SECTION("auditionSection", "audition"),
	PRODUCTION_SECTION("productionSection", "production"),
	DONATE_SECTION("donateSection", "donation"),
	AUDITION_INFORMATION_SECTION("auditionInformation", "auditionInformation"),
	CONTACT_SECTION("contactSection", "contactSection"),
	HOME_TOP("homeTop", "homeTop"),
	HOME_COLLAPSE_ONE("homeCollapseOne", "homeCollapseOne"),
	HOME_COLLAPSE_TWO("homeCollapseTwo", "homeCollapseTwo"),
	HOME_COLLAPSE_THREE("homeCollapseThree", "homeCollapseThree"),
	HOME_COL_ONE("homeColOne", "homeColOne"),
	HOME_COL_TWO("homeColTwo", "homeColTwo"),
	HOME_COL_THREE("homeColhree", "homeColThree");

	private String sectionType;
	private String divKey;
	
	PageSectionType(String sectionType, String divKey) {
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
		for(PageSectionType type : PageSectionType.values()) {
			if(key.equals(type.getDivKey())) {
				return type.getSectionType();
			}
		}
		
		return null;
	}
}
