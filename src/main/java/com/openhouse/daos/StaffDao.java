package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.openhouse.beans.StaffMemberTO;

public class StaffDao {
	private static final String SELECT_ALL_STAFF = 
		"SELECT " 
	+ 		"id, first_name, last_name, title, bio, image_path, image_public_id " 
	+ 	"FROM " 
	+ 		"oh_staff ORDER BY order_num ASC";

	private static final String INSERT_NEW_STAFF = 
		"INSERT INTO " 
	+ 		"oh_staff " 
	+		"(first_name, last_name, title, bio, image_path, image_public_id) " 
	+ 	"VALUES (?, ?, ?, ?, ?, ?)";

	private static final String REMOVE_STAFF_MEMBER = "DELETE FROM oh_staff WHERE id = ?";

	private static final String UPDATE_STAFF_MEMBER = 
		"UPDATE oh_staff " 
	+ 		"SET " 
	+ 			"first_name = ?, last_name = ?, " 
	+ 			"title = ?, bio = ?, image_path = ?, " 
	+ 			"image_public_id = ? " 
	+ 		"WHERE " 
	+ 			"id = ?";
	

	public List<StaffMemberTO> getStaffList() {
		List<StaffMemberTO> staffMembers = new ArrayList<>();

		try (final Connection connection = DatabaseConnection.getConnection()) {
			final Statement statement = connection.createStatement();
			final ResultSet results = statement.executeQuery(SELECT_ALL_STAFF);
			
			while(results.next()){
				staffMembers.add(new StaffMemberTO(
					results.getInt(1),
					results.getString(2), 
					results.getString(3), 
					results.getString(4), 
					results.getString(5), 
					results.getString(6),
					results.getString(7)));
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 

		return staffMembers;
	}

	public boolean addStaffMember(final StaffMemberTO staffMember) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(INSERT_NEW_STAFF);

			statement.setString(1, staffMember.getFirstName());
			statement.setString(2, staffMember.getLastName());
			statement.setString(3, staffMember.getTitle());
			statement.setString(4, staffMember.getBio());
			statement.setString(5, staffMember.getImagePath());
			statement.setString(6, staffMember.getImagePublicId());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 
		
		return false;
	}

	public boolean removeStaffMember(final StaffMemberTO staffMember) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(REMOVE_STAFF_MEMBER);

			statement.setInt(1, staffMember.getId());

			if (statement.executeUpdate() > 0) { 
				return true;
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 

		return false;
	}

	public boolean editStaffMember(final StaffMemberTO staffMember) { 
		try (final Connection connection = DatabaseConnection.getConnection()) {
			final PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF_MEMBER);

			statement.setString(1, staffMember.getFirstName());
			statement.setString(2, staffMember.getLastName());
			statement.setString(3, staffMember.getTitle());
			statement.setString(4, staffMember.getBio());
			statement.setString(5, staffMember.getImagePath());
			statement.setString(6, staffMember.getImagePublicId());
			statement.setInt(7, staffMember.getId());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 

		return false;
	}
}