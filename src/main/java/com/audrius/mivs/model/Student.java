package com.audrius.mivs.model;

public class Student extends User {
    private String userCode;


    public Student(String userName, String firstName, String secondName, String password, String userCode) {
        super(userName, firstName, secondName, password, Role.ADMIN);
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}