package com.audrius.mivs.model;

public class Admin extends User {

    public Admin(String firstName, String secondName,String userName,  String password) {
        super(firstName, secondName,userName, password, Role.ADMIN);
    }
}