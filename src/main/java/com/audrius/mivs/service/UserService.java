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
    private UserRepository userRepository = new UserRepository();

    public User login() {
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

    public User findUser(String username) {
        return userRepository.findByUserName(username);
    }

    public HashMap<String, User> findAllUsers() {
        try {
            return (HashMap<String, User>) IOObjectStreamUtils.readFirstObjectFromFile("users");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void createUser(String firstName, String secondName, String userName, String password, Role role) {
        userRepository.createUser(firstName, secondName, userName, password, role.toString());
    }

    public void save(User user) {
        HashMap<String, User> allUsers = findAllUsers();
        allUsers.put(user.getUserName(), user);
        IOObjectStreamUtils.writeObjectToFile("users", allUsers);
    }
}
