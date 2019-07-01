package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.openhouse.beans.StaffMemberTO;

public class StaffDao {
	private static final String SELECT_ALL_STAFF = 
		"SELECT " 
	+ 		"id, first_name, last_name, title, bio, image_path " 
	+ 	"FROM " 
	+ 		"oh_staff";

	public List<StaffMemberTO> getStaffList() {
		List<StaffMemberTO> staffMembers = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(SELECT_ALL_STAFF);
			
			while(results.next()){
				staffMembers.add(new StaffMemberTO(
					results.getInt(1),
					results.getString(2), 
					results.getString(3), 
					results.getString(4), 
					results.getString(5), 
					results.getString(6)));
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 

		return staffMembers;
	}

	public boolean addStaffMember(StaffMemberTO staffMember) {
		return false;
	}

	public boolean removeStaffMember(StaffMemberTO staffMember) {
		return false;
	}

	public boolean editStaffMember(StaffMemberTO staffMemeber) { 
		return false;
	}
}