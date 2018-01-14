package com.audrius.mivs.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class User implements Serializable {
    private String userId;
    private String  userName;
    private String  firstName;
    private String secondName;
    private String password;
    private Role role;

    User(String firstName, String secondName, String userName, String password, Role userRole) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.role = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
