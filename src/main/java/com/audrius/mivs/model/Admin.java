package com.audrius.mivs.model;

public class Admin extends User {

    public Admin(String userName, String firstName, String secondName, String password) {
        super(userName, firstName, secondName, password, Role.ADMIN);
    }
}