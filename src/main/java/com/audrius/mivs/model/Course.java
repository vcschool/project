package com.audrius.mivs.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Course implements Serializable {
    private String courseCode;
    private String title;
    private String description;
    private LocalDate startDate;
    private String lecturerCode;

    public Course(String title, String description, LocalDate startDate, String lecturerCode) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.lecturerCode = lecturerCode;
        this.courseCode = UUID.randomUUID().toString();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
    }
}
