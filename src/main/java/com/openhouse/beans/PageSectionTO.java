package com.openhouse.beans;

public class PageSectionTO {
	private String sectionType;
	private String sectionContent;
	private String additionalProperties;
	
	public String getSectionType() {
		return sectionType;
	}
	
	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}
	
	public String getSectionContent() {
		return sectionContent;
	}
	
	public void setSectionContent(String sectionContent) {
		this.sectionContent = sectionContent;
	}

	public String getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(String additionalProperties) {
		this.additionalProperties = additionalProperties;
	}	
}
