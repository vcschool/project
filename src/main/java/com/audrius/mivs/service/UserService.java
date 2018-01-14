package com.audrius.mivs.service;

import com.audrius.mivs.model.Admin;
import com.audrius.mivs.model.Lecturer;
import com.audrius.mivs.model.Role;
import com.audrius.mivs.model.Student;
import com.audrius.mivs.model.User;
import com.audrius.mivs.utils.IOObjectStreamUtils;
import com.audrius.mivs.utils.ScannerUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class UserService {
    public static User login() {
        System.out.println("Welcome! Please login.");
        while (true) {
            String username = ScannerUtils.scanString("Username:");
            String password = ScannerUtils.scanString("Password: ");

            User user = findUser(username);
            if (user != null
                    && username.equals(user.getUserName())
                    && password.equals(user.getPassword())) {
                return user;
            }
            System.out.println("Login failed, please try again");
        }
    }

    public static User findUser(String username) {
        HashMap<String, User> users;
        try {
            users = (HashMap<String, User>) IOObjectStreamUtils.readFirstObjectFromFile("users");
            return users.get(username);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public HashMap<String, User> findAllUsers() {
        try {
            return (HashMap<String, User>) IOObjectStreamUtils.readFirstObjectFromFile("users");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void createUser(String firstName, String secondName, String userName, String password, Role role) {
        User user = null;
        switch (role) {
            case ADMIN:
                user = new Admin(firstName, secondName, userName, password);
                break;
            case STUDENT:
                user = new Student(firstName, secondName, userName, password);
                break;
            case LECTURER:
                user = new Lecturer(firstName, secondName, userName, password);
                break;
        }
        try {
            HashMap<String, User> users = (HashMap<String, User>) IOObjectStreamUtils.readFirstObjectFromFile("users");
            users.put(user.getUserName(), user);
            IOObjectStreamUtils.writeObjectToFile("users", users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(User user) {
        HashMap<String, User> allUsers = findAllUsers();
        allUsers.put(user.getUserName(), user);
        IOObjectStreamUtils.writeObjectToFile("users", allUsers);
    }
}
