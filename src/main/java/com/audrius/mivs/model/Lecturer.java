package com.audrius.mivs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lecturer extends User {

    private List<String> leadLectures = new ArrayList<>();

    public Lecturer(String firstName, String secondName, String userName, String password) {
        super(firstName, secondName,userName, password, Role.LECTURER);
    }

    public List<String> getLeadLectures() {
        return leadLectures;
    }

    public void addLeadLecture(String lecturerCode) {
        this.leadLectures.add(lecturerCode);
    }
}
