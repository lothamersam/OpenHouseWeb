package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.openhouse.beans.PageSectionTO;
import com.openhouse.services.enums.PageSectionType;

public class BasicPageDao {
	private static final String GET_PAGE_SECTION = "SELECT content, additional_properties FROM oh_about WHERE attribute_name = ? LIMIT 1";
	
	private static final String EDIT_PAGE_SECTION = "UPDATE oh_about SET content = ?, additional_properties = ? WHERE attribute_name = ?";
	
	public PageSectionTO getPageSection(final PageSectionType sectionType) {
		final PageSectionTO aboutSection = new PageSectionTO();
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_PAGE_SECTION);
			
			statement.setString(1, sectionType.getSectionType());
			
			final ResultSet results = statement.executeQuery();
			if (results.next()) {
				aboutSection.setSectionContent(results.getString(1));
				aboutSection.setAdditionalProperties(results.getString(2));
				aboutSection.setSectionType(sectionType.getSectionType());				
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return aboutSection;	
	}
	
	public boolean editPageSection(final PageSectionTO pageSection) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(EDIT_PAGE_SECTION);
			
			statement.setString(1, pageSection.getSectionContent());
			statement.setString(2, pageSection.getAdditionalProperties());
			statement.setString(3, pageSection.getSectionType());
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}
