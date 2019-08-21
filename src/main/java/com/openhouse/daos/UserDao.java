package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import com.openhouse.beans.UserTO;

public class UserDao {
	private static final String GET_USER = "SELECT username, password, id FROM oh_uman WHERE username = ?";
	private static final String GET_USER_ID = "SELECT username, password, id FROM oh_uman WHERE id = ?";
	private static final String GET_USER_LIST = "SELECT id, first_name, last_name, username FROM oh_uman";
	private static final String ADD_USER = "INSERT INTO oh_uman (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
	private static final String REMOVE_USER = "DELETE FROM oh_uman WHERE id = ?";
	private static final String UPDATE_USER = "UPDATE oh_uman SET password = ? WHERE id = ?";
	public static final String ERROR = "There was an error when querying the database! ";
	public static final String MESSAGE = "message";

	public UserTO getUser(String username) {
		final UserTO user = new UserTO();

		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(GET_USER)) {

			statement.setString(1, username);

			try (ResultSet results = statement.executeQuery()) {
				while (results.next()) {
					user.setUsername(results.getString(1));
					user.setPassword(results.getString(2));
					user.setId(results.getInt(3));
				}
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}

		return user;
	}

	public List<UserTO> getUserList() {
		List<UserTO> users = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(GET_USER_LIST)) {

			while (results.next()) {
				users.add(new UserTO(results.getInt(1),
						results.getString(2),
						results.getString(3),
						results.getString(4)));
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}

		return users;
	}

	public JSONObject addUser(UserTO user) {
		final JSONObject response = new JSONObject();

		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(ADD_USER)) {

			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());

			if (statement.executeUpdate() > 0) {
				response.put(MESSAGE, "Added user successfully!");
			}
		} catch (URISyntaxException e) {
			System.out.println(ERROR + e.getMessage());
		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());

			if (e.getErrorCode() == 1062) {
				response.put(MESSAGE, "Username already exists!");
			} else {
				response.put(MESSAGE, "Could not add user!");
			}
		}

		return response;
	}

	public JSONObject updateUser(UserTO user, String oldPass) {
		final JSONObject response = new JSONObject();

		if (this.verifyUser(user, oldPass)) {
			try (Connection connection = DatabaseConnection.getConnection();
				final PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {

				statement.setString(1, user.getPassword());
				statement.setInt(2, user.getId());

				if (statement.executeUpdate() > 0) {
					response.put(MESSAGE, "Password changed successfully!");
				}
			} catch (URISyntaxException | SQLException e) {
				System.out.println(ERROR + e.getMessage());
				response.put(MESSAGE, "Could not update your password!");
			}
		} else {
			response.put(MESSAGE, "Old password incorrect!");
		}

		return response;
	}

	public JSONObject removeUser(int id) {
		final JSONObject response = new JSONObject();

		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(REMOVE_USER)) {

			statement.setInt(1, id);

			if (statement.executeUpdate() > 0) {
				response.put(MESSAGE, "User removed successfully!");
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println(ERROR + e.getMessage());
			response.put(MESSAGE, "Could not remove user!");
		}

		return response;
	}

	private boolean verifyUser(UserTO user, String oldPass) {
		final UserTO fetchedUser = new UserTO();

		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(GET_USER_ID)) {

			statement.setInt(1, user.getId());

			try (ResultSet results = statement.executeQuery()) {
				while (results.next()) {
					fetchedUser.setUsername(results.getString(1));
					fetchedUser.setPassword(results.getString(2));
					fetchedUser.setId(results.getInt(3));
				}
			}
		} catch (URISyntaxException | SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}

		return BCrypt.checkpw(oldPass, fetchedUser.getPassword());
	}
}
