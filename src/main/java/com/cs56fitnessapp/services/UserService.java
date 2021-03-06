package com.cs56fitnessapp.services;

import com.cs56fitnessapp.models.ActivityLevel;
import com.cs56fitnessapp.models.Gender;
import com.cs56fitnessapp.models.Goal;
import com.cs56fitnessapp.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
/**
 * @author Ksenia Koldaeva
 * Created: 12/2/17
 * Last Updated: 12/2/17
 */

/**
 * This class provides services for adding information to the database
 * and fetching information back
 * that is related to the User
 */
public class UserService {

    /**
     * Adds user to db
     * @param user
     */
    public static void addUserToDb(User user) {
        // TODO refactor try - catch to be handled by the caller
        try {
            Connection connection = SqLiteConnection.getConnectionObj();

            Statement statement = connection.createStatement();
            String sqlQuery = "INSERT INTO user(name, username, email, password, date_of_birth, gender, body_mass_kg, height_cm, goal, weekly_goal_kg, activity_level) VALUES(" +
                    "'" + user.getName() + "'," +
                    "'" + user.getUsername() + "'," +
                    "'" + user.getEmail() + "'," +
                    "'" + user.getPassword() + "'," +
                    "'" + user.getDateOfBirth() + "'," +
                    "'" + user.getGender().getDbValue() + "'," +
                          user.getBodyMassKg() + "," +
                          user.getHeightCm() + "," +
                    "'" + user.getGoal().getDbValue() + "'," +
                          user.getWeeklyGoalKg() + "," +
                    "'" + user.getActivityLevel().getDbValue() + "')";

            statement.executeUpdate(sqlQuery);
            SqLiteConnection.closeConnection();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static User getUserById(long id) throws SQLException, ClassNotFoundException {
        // TODO potential edge case: if value will be not init from DB, blank user will be created.
        String name = "";
        String username = "";
        String email = "";
        String password = "";
        LocalDate dateOfBirth = null;
        Gender gender = null;
        double bodyMassKg = 0.0;
        double heightCm = 0.0;
        Goal goal = null;
        double weeklyGoalKg = 0.0;
        ActivityLevel activityLevel = null;

        Connection connection = SqLiteConnection.getConnectionObj();
        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT * FROM user WHERE id = '" + id + "'";
        ResultSet rs = statement.executeQuery(sqlQuery);

        while(rs.next()) {
            // read the result set
            name = rs.getString("name");
            username = rs.getString("username");
            email = rs.getString("email");
            password = rs.getString("password");
            gender = rs.getString("gender") == null ? null : Gender.fromDbValue(rs.getString("gender"));
            dateOfBirth = rs.getString("date_of_birth") == null ? null : LocalDate.parse(rs.getString("date_of_birth"));
            bodyMassKg = rs.getDouble("body_mass_kg");
            heightCm = rs.getDouble("height_cm");
            goal = rs.getString("goal") == null ? null : Goal.fromDbValue(rs.getString("goal"));
            weeklyGoalKg = rs.getDouble("weekly_goal_kg");
            activityLevel = rs.getString("activity_level") == null ? null : ActivityLevel.fromDbValue(rs.getString("activity_level"));
        }

        SqLiteConnection.closeConnection();
        return new User(id, name, username, email, password, dateOfBirth, gender, bodyMassKg, heightCm, goal, weeklyGoalKg, activityLevel);
    }

    /**
     * @return true if database has at least one user registered
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static boolean dbHasUser() throws SQLException, ClassNotFoundException {
        Connection connection = SqLiteConnection.getConnectionObj();

        Statement statement = connection.createStatement();

        // Check if table has data in it
        String sqlQuery = "SELECT count(*) as user_count FROM user";
        ResultSet rs = statement.executeQuery(sqlQuery);


        while(rs.next()) {
            // read the result set
            // If it has user - pick the first user and use it in the application
            if (rs.getInt("user_count") > 0) {
                return true;
            }
        }

        SqLiteConnection.closeConnection();
        return false;
    }
}

