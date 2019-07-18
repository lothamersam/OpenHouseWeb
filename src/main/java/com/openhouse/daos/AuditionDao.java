package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.openhouse.beans.AuditionDateTO;
import com.openhouse.beans.PageSectionTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuditionDao {
	private static final String GET_AUDITION_SECTION = "SELECT content, additional_properties FROM oh_audition WHERE attribute_name = ? LIMIT 1";
	private static final String EDIT_AUDITION_SECTION = "UPDATE oh_audition SET content = ?, additional_properties = ? WHERE attribute_name = ?";
	private static final String GET_AUDITION_DATES = "SELECT id, date, location, time, information FROM oh_dates";
	private static final String ADD_AUDITION_DATE = "INSERT INTO oh_dates (date, location, time, information) VALUES (?, ?, ?, ?)";
	private static final String EDIT_AUDITION_DATE = "UPDATE oh_dates SET date = ?, location = ?, time = ?, information = ? WHERE id = ?";
	
	
	public PageSectionTO getAuditionSection() {
		final PageSectionTO aboutSection = new PageSectionTO();
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_AUDITION_SECTION);
			
			
			final ResultSet results = statement.executeQuery();
			if (results.next()) {
								
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return aboutSection;	
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
			if (results.next()) {
								
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