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
	private static final String GET_AUDITION_SECTION = "";
	private static final String EDIT_AUDITION_SECTION = "";
	private static final String GET_AUDITION_DATES = "";
	private static final String ADD_AUDITION_DATE = "";
	private static final String EDIT_AUDITION_DATE = "";
	
	
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
		
		return datesList;
	}
	
	public boolean addAuditionDate() {
		
		
		return false;
	}
	
	public boolean editAuditionDate() {
		
		
		return false;
	}
}