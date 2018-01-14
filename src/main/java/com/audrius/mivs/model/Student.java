package com.audrius.mivs.model;

public class Student extends User {

    public Student(String firstName, String secondName,String userName, String password) {
        super(firstName, secondName,userName, password, Role.STUDENT);
    }

}