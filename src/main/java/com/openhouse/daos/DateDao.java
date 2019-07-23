package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.openhouse.beans.DateTO;
import com.openhouse.services.enums.DateType;

public class DateDao {
	private static final String GET_AUDITION_DATES = "SELECT id, date, time, location, information FROM oh_dates WHERE type = ?";
	private static final String ADD_AUDITION_DATE = "INSERT INTO oh_dates (date, location, time, information, type) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_AUDITION_DATE = "DELETE FROM oh_dates WHERE id = ?";	
	
	public List<DateTO> getDates(DateType dateType) {
		final List<DateTO> datesList = new ArrayList<>();
				
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_AUDITION_DATES);
			
			statement.setString(1, dateType.getType());
			
			final ResultSet results = statement.executeQuery();
			while (results.next()) {
				datesList.add(new DateTO(
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
	
	public boolean addDate(final DateTO date) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(ADD_AUDITION_DATE, 
										  Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, date.getDate());
			statement.setString(3, date.getTime());
			statement.setString(2, date.getLocation());
			statement.setString(4, date.getInformation());
			statement.setString(5, date.getType());
			
			final int id = statement.executeUpdate();
			
			// insert time range
			
			return id > 0;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	public boolean removeDate(int id) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(DELETE_AUDITION_DATE);

			statement.setInt(1, id);
			
			// remove time slots

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}
