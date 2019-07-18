package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.openhouse.beans.PageSectionTO;
import com.openhouse.services.enums.AboutSectionType;

public class AboutDao {
	private static final String GET_ABOUT_SECTION = "SELECT content, additional_properties FROM oh_about WHERE attribute_name = ? LIMIT 1";
	
	private static final String EDIT_ABOUT_SECTION = "UPDATE oh_about SET content = ?, additional_properties = ? WHERE attribute_name = ?";
	
	public PageSectionTO getAboutSection(final AboutSectionType sectionType) {
		final PageSectionTO aboutSection = new PageSectionTO();
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_ABOUT_SECTION);
			
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
	
	public boolean editAboutSection(final PageSectionTO aboutSection) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(EDIT_ABOUT_SECTION);
			
			statement.setString(1, aboutSection.getSectionContent());
			statement.setString(2, aboutSection.getAdditionalProperties());
			statement.setString(3, aboutSection.getSectionType());
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}