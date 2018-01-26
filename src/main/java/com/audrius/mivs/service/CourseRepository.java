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
import java.time.LocalDate;

public class CourseRepository {
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
                        "CREATE TABLE IF NOT EXISTS course " +
                                "(" +
                                "    courseCode VARCHAR(50) NOT NULL," +
                                "    title VARCHAR(50)," +
                                "    description VARCHAR(50)," +
                                "    startDate VARCHAR(50)," +
                                "    lecturerUsername VARCHAR(10)," +
                                "    PRIMARY KEY(coursecode)" +
                                ");"
                )
        ) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createCourse(String courseCode, String title, String description, LocalDate startDate, String lecturerUserName) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO course (" +
                                "courseCode,title,description,startDate,lecturerUserName)" +
                                " VALUES (?,?,?,?,?)")
        ) {
            statement.setString(1, courseCode);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, startDate.toString());
            statement.setString(5, lecturerUserName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

