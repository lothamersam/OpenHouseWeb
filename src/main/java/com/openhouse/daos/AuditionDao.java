package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.openhouse.beans.AuditionDateTO;
import com.openhouse.beans.SignupInformationTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuditionDao extends BasicPageDao {
	private static final String GET_SIGNUPS = "SELECT first_name, last_name, date, email, pronouns FROM oh_audition";
	private static final String ADD_SIGNUP = "INSERT INTO oh_audition (first_name, last_name, email, pronouns, date) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_AUDITION_DATES = "SELECT id, date, time, location, information FROM oh_dates";
	private static final String ADD_AUDITION_DATE = "INSERT INTO oh_dates (date, location, time, information) VALUES (?, ?, ?, ?)";
	private static final String EDIT_AUDITION_DATE = "UPDATE oh_dates SET date = ?, time = ?, location = ?, information = ? WHERE id = ?";	
	
	public List<SignupInformationTO> getAuditionSignups() {
		final List<SignupInformationTO> signupList = new ArrayList<>(); 
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final Statement statement = connection.createStatement();
			final ResultSet results = statement.executeQuery(GET_SIGNUPS);
			
			while(results.next()){
				signupList.add(new SignupInformationTO(
					results.getString(1),
					results.getString(2), 
					results.getString(3),
					results.getString(5), 
					results.getString(5)));
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return signupList;
	}
	
	public boolean addAuditionSignup(final SignupInformationTO signupInformation) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(ADD_SIGNUP);

			statement.setString(1, signupInformation.getFirstName());
			statement.setString(2, signupInformation.getLastName());
			statement.setString(3, signupInformation.getEmail());
			statement.setString(4, signupInformation.getPronouns());
			statement.setString(5, signupInformation.getDate());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (URISyntaxException | SQLException e) {
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
	
	public boolean addAuditionDate(final AuditionDateTO date) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(ADD_AUDITION_DATE);
			
			statement.setString(1, date.getDate());
			statement.setString(3, date.getTime());
			statement.setString(2, date.getLocation());
			statement.setString(4, date.getInformation());
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	public boolean editAuditionDate(final AuditionDateTO date) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(EDIT_AUDITION_DATE);
			
			statement.setString(1, date.getDate());
			statement.setString(3, date.getTime());
			statement.setString(2, date.getLocation());
			statement.setString(4, date.getInformation());
			statement.setInt(5, date.getId());
			
			return statement.executeUpdate() > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}