package com.openhouse.daos;

import com.openhouse.beans.SignupInformationTO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AuditionDao extends BasicPageDao {
    private static final String ERROR = "There was an error when querying the database! ";
    private static final String GET_SIGNUPS =
            "SELECT first_name, last_name, pronouns, date, email, id, phone_number FROM oh_audition";
    private static final String ADD_SIGNUP =
            "INSERT INTO oh_audition (first_name, last_name, email, pronouns, date, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_SIGNUP = "DELETE FROM oh_audition WHERE id = ?";

    public List<SignupInformationTO> getAuditionSignups() {
        final List<SignupInformationTO> signupList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(GET_SIGNUPS)) {

            while (results.next()) {
                signupList.add(new SignupInformationTO(
                        results.getInt(6),
                        results.getString(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        results.getString(7)));
            }
        } catch (URISyntaxException | SQLException e) {
            System.out.println(ERROR + e.getMessage());
        }

        return signupList;
    }

    public int addAuditionSignup(final SignupInformationTO signupInformation) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_SIGNUP,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, signupInformation.getFirstName());
            statement.setString(2, signupInformation.getLastName());
            statement.setString(3, signupInformation.getEmail());
            statement.setString(4, signupInformation.getPronouns());
            statement.setString(5, signupInformation.getDate());
            statement.setString(6, signupInformation.getPhoneNumber());

            statement.executeUpdate();

            try (ResultSet results = statement.getGeneratedKeys()) {
                if (results.next()) {
                    return results.getInt(1);
                }
            }
        } catch (URISyntaxException | SQLException e) {
            System.out.println(ERROR + e.getMessage());
        }

        return 0;
    }

    public boolean deleteAuditionSignup(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SIGNUP)) {

            statement.setInt(1, id);

            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (URISyntaxException | SQLException e) {
            System.out.println(ERROR + e.getMessage());
        }

        return false;
    }
}