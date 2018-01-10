package com.audrius.mivs.service;

import com.audrius.mivs.model.User;
import com.audrius.mivs.utils.IOObjectStreamUtils;
import com.audrius.mivs.utils.ScannerUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class UserService {
    public static User login() {
        System.out.println("Welcome! Please login.");
        while (true) {
            System.out.print("Username: ");
            String username = ScannerUtils.scanString();
            System.out.print("Password: ");
            String password = ScannerUtils.scanString();

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
}
