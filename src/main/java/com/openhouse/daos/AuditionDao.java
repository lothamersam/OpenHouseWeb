package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.openhouse.beans.AuditionDateTO;
import com.openhouse.beans.PageSectionTO;
import com.openhouse.beans.SignupInformationTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuditionDao {
	private static final String GET_AUDITION_SECTION = "SELECT content, additional_properties FROM oh_audition WHERE attribute_name = ? LIMIT 1";
	private static final String EDIT_AUDITION_SECTION = "UPDATE oh_audition SET content = ?, additional_properties = ? WHERE attribute_name = ?";
	private static final String GET_AUDITION_DATES = "SELECT id, date, time, location, information FROM oh_dates";
	private static final String ADD_AUDITION_DATE = "INSERT INTO oh_dates (date, location, time, information) VALUES (?, ?, ?, ?)";
	private static final String EDIT_AUDITION_DATE = "UPDATE oh_dates SET date = ?, location = ?, time = ?, information = ? WHERE id = ?";
	
	
	public PageSectionTO getAuditionSection() {
		final String pageSectionName = "auditionInformation";
		final PageSectionTO auditionSection = new PageSectionTO();
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_AUDITION_SECTION);
			
			statement.setString(1, pageSectionName);
			
			final ResultSet results = statement.executeQuery();
			if (results.next()) {
				auditionSection.setSectionType(pageSectionName);
				auditionSection.setSectionContent(results.getString(1));
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return auditionSection;	
	}
	
	
	public List<SignupInformationTO> getAuditionSignups() {
		final List<SignupInformationTO> signupList = new ArrayList<>(); 
		
		return signupList;
	}
	
	public boolean addAuditionSignup(final SignupInformationTO signupInformation) {
		
		
		return false;
	}
	
	public boolean editAuditionSection(final PageSectionTO pageSection) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(EDIT_AUDITION_SECTION);
			
			
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	public List<AuditionDateTO> getAuditionDate() {
		final List<AuditionDateTO> datesList = new ArrayList<>();
				
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_AUDITION_DATES);
			
			
			final ResultSet results = statement.executeQuery();
			while (results.next()) {
				datesList.add(new AuditionDateTO(
						results.getInt(1),
						results.getString(2),
						results.getString(3),
						results.getString(4),
						results.getString(5)));			
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
				
		return datesList;
	}
	
	public boolean addAuditionDate() {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(ADD_AUDITION_DATE);
			
			
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	public boolean editAuditionDate() {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(EDIT_AUDITION_DATE);
			
			
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}