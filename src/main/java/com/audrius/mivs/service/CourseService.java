package com.audrius.mivs.service;

import com.audrius.mivs.model.Course;
import com.audrius.mivs.model.Lecturer;
import com.audrius.mivs.model.Role;
import com.audrius.mivs.model.User;
import com.audrius.mivs.utils.IOObjectStreamUtils;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;

public class CourseService {
    private UserService userService = new UserService();
    private CourseRepository courseRepository = new CourseRepository();

    public HashMap<String, Course> findAllCourses() {
        try {
            return (HashMap<String, Course>) IOObjectStreamUtils.readFirstObjectFromFile("courses");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void createCourse(String courseCode, String title, String description, LocalDate startDate, String lecturerUserName) {
        User user = userService.findUser(lecturerUserName);
        if (user != null && user.getRole() != Role.LECTURER) {
            System.out.println("This user can not drive the course");
            return;
        }
        courseRepository.createCourse(courseCode,title,description,startDate,lecturerUserName);
    }
}
