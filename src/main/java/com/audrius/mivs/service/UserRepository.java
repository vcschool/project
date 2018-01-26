package com.audrius.mivs.service;

import com.audrius.mivs.model.Admin;
import com.audrius.mivs.model.Lecturer;
import com.audrius.mivs.model.Student;
import com.audrius.mivs.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:/home/audrius/mivs";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "sa";

    public void createTable() {


        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS user " +
                                "(" +
                                "    username VARCHAR(50) NOT NULL," +
                                "    password VARCHAR(50)," +
                                "    firstName VARCHAR(50)," +
                                "    secondName VARCHAR(50)," +
                                "    role VARCHAR(10)," +
                                "    PRIMARY KEY(username)" +
                                ");"
                )
        ) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User findByUserName(String userName) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM user WHERE username = ?"
                )
        ) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            switch (resultSet.getString("role")) {
                case "ADMIN":
                    return new Admin(resultSet.getString("firstName"),
                            resultSet.getString("secondName"),
                            resultSet.getString("userName"),
                            resultSet.getString("password"));
                case "LECTURER":
                    return new Lecturer(resultSet.getString("firstName"),
                            resultSet.getString("secondName"),
                            resultSet.getString("userName"),
                            resultSet.getString("password"));
                case "STUDENT":
                    return new Student(resultSet.getString("firstName"),
                            resultSet.getString("secondName"),
                            resultSet.getString("userName"),
                            resultSet.getString("password"));
                default:
                    return null;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void createUser(String firstName, String secondName, String userName, String password, String role) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO user (" +
                                "firstName,secondName,userName,password,role)" +
                                " VALUES (?,?,?,?,?)")
                ) {
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, userName);
            statement.setString(4, password);
            statement.setString(5, role);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

