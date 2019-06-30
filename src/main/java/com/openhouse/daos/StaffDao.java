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
	private final String SELECT_ALL_STAFF = "SELECT * FROM oh_staff";

	public List<StaffMemberTO> getStaffList() {
		List<StaffMemberTO> staffMembers = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(SELECT_ALL_STAFF);
			
			while(results.next()){
				staffMembers.add(new StaffMemberTO(
					results.getString(1), results.getString(2), results.getString(3), results.getString(4)));
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println("There was an error when querying the database! " + e.getMessage());
		} 

		return staffMembers;
	}

	public boolean addStaffMemeber(StaffMemberTO staffMember) {
		return false;
	}

	public boolean removeStaffMember(StaffMemberTO staffMember) {
		return false;
	}

	public boolean editStafffMember(StaffMemberTO staffMemeber) { 
		return false;
	}

	public void getStaffPhoto(StaffMemberTO staffMember){
		
	}
}