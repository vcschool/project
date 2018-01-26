package com.audrius.mivs.ui.admin;

import com.audrius.mivs.model.Course;
import com.audrius.mivs.service.CourseService;
import com.audrius.mivs.utils.ScannerUtils;

import java.time.LocalDate;
import java.util.HashMap;


class CourseManagementMenu {
    private CourseService courseService = new CourseService();

    void open() {
        System.out.println();
        System.out.println("Course management menu");
        System.out.println("=====================");
        System.out.println("1. Show all  courses");
        System.out.println("2. Add course");
        System.out.println("3. Back");

        int choice = ScannerUtils.scanInt(1, 3);

        switch (choice) {
            case 1:
                showAllCourses();
                break;
            case 2:
                addCourse();
                break;
            case 3: break;
        }
    }

    private void showAllCourses() {
        System.out.println();
        System.out.println("All courses");
        System.out.println("===========");
        HashMap<String, Course> allCourses = courseService.findAllCourses();
        System.out.format("| %-40s | %-10s | %-40s | %-10s |%n%n", "COURSE CODE", "TITLE", "LECTURER CODE", "START DATE");

        for (Course course : allCourses.values()) {
            System.out.format("| %-40s | %-10s | %-40s | %-10s |%n", course.getCourseCode(), course.getTitle(), course.getLecturerCode(), course.getStartDate());
        }
    }

    private void addCourse() {
        System.out.println();
        System.out.println("Add course");
        System.out.println("==========");
        String courseCode = ScannerUtils.scanString("Enter cours code");
        String title = ScannerUtils.scanString("Enter title");
        String description = ScannerUtils.scanString("Enter description");
        LocalDate startDate = LocalDate.parse(ScannerUtils.scanString("Enter start date yyyy-mm-dd"));
        String userName = ScannerUtils.scanString("Enter lecturer user name");

        courseService.createCourse(courseCode,title, description, startDate, userName);
    }
}
