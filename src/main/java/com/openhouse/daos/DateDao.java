package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.openhouse.beans.DateTO;
import com.openhouse.services.enums.DateType;

public class DateDao {
	private static final String GET_AUDITION_DATES = "SELECT id, date, time, location, information, end_time FROM oh_dates WHERE type = ?";
	private static final String ADD_AUDITION_DATE = "INSERT INTO oh_dates (date, location, time, information, type, end_time) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_AUDITION_DATE = "DELETE FROM oh_dates WHERE id = ?";	
	
	private static final String ADD_TIME_SLOT = "INSERT INTO oh_times (audition_id, time) VALUES (?, ?)";
	private static final String GET_TIME_SLOTS = "SELECT id, audition_id, time FROM oh_times WHERE audition_id = ? AND signup_id IS NULL";
	private static final String ASSIGN_TIME_SLOT = "UPDATE oh_times SET signup_id = ? WHERE id = ?";
	private static final String DELETE_TIME_SLOTS = "DELETE FROM oh_times WHERE audition_id = ?";
	
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
						results.getString(6), 
						results.getString(4),
						results.getString(5)));			
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
				
		return datesList;
	}
	
	public boolean addDate(final DateTO date) {
		boolean status = false; 
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(ADD_AUDITION_DATE, 
										  Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, date.getDate());
			statement.setString(3, date.getStartTime());
			statement.setString(6, date.getEndTime());
			statement.setString(2, date.getLocation());
			statement.setString(4, date.getInformation());
			statement.setString(5, date.getType());
			
			status = statement.executeUpdate() > 0;
			
			ResultSet results = statement.getGeneratedKeys();
			if(results.next()) {
				return status && this.addTimes(results.getInt(1), date.getStartTime(), date.getEndTime());
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}


	public boolean removeDate(int id) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(DELETE_AUDITION_DATE);

			statement.setInt(1, id);

			return statement.executeUpdate() > 0 && this.removeTimes(id);
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	private boolean addTimes(int id, String startTime, String endTime) {
		final DateTimeFormatter formatter = DateTimeFormat.forPattern("hh:mmaa");
		final LocalTime startLocalTime = formatter.parseLocalTime(startTime);
		final LocalTime endLocalTime = formatter.parseLocalTime(endTime);
		boolean status = false;
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(ADD_TIME_SLOT);
			
			statement.setInt(1, id);
			
			for(LocalTime timeCounter = startLocalTime; 
					timeCounter.isBefore(endLocalTime); 
					timeCounter = timeCounter.plusMinutes(5)){
				String timeParsed = timeCounter.toString("hh:mmaa");
				statement.setString(2, timeParsed);
				
				status = statement.executeUpdate() > 0;
			}
			
			return status;
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return status;
	}
	
	public JSONObject getTimes(int id) {
		final JSONObject timesList = new JSONObject();
		final JSONArray timesArray = new JSONArray();
		JSONObject singleTime = new JSONObject();
		
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(GET_TIME_SLOTS);
			
			statement.setInt(1, id);
			
			final ResultSet results = statement.executeQuery();
			while (results.next()) {
				singleTime = new JSONObject()
						.put("id", results.getInt(1))
						.put("audition_id", results.getInt(2))
						.put("time", results.getInt(3));
				timesArray.put(singleTime.toString());
			}
		} catch (SQLException | URISyntaxException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		timesList.put("times", timesArray);
				
		return timesList;
	}
	
	public boolean assignTime(int signupId, int auditionId) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(ASSIGN_TIME_SLOT);

			statement.setInt(1, signupId);
			statement.setInt(1, auditionId);
			
			return statement.executeUpdate() > 0;
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
	
	private boolean removeTimes(int id) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(DELETE_TIME_SLOTS);

			statement.setInt(1, id);
			
			return statement.executeUpdate() > 0;
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}
}
