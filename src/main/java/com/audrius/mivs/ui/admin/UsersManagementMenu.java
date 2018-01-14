package com.audrius.mivs.ui.admin;

import com.audrius.mivs.model.Role;
import com.audrius.mivs.model.User;
import com.audrius.mivs.service.UserService;
import com.audrius.mivs.utils.ScannerUtils;

import java.util.HashMap;


class UsersManagementMenu {
    private UserService userService = new UserService();

    void open() {
        System.out.println();
        System.out.println("Users management menu");
        System.out.println("=====================");
        System.out.println("1. Show all  user");
        System.out.println("2. Add  user");
        System.out.println("3. Back");

        int choice = ScannerUtils.scanInt(1, 3);

        switch (choice) {
            case 1:
                showAllUsers();
                break;
            case 2:
                addUser();
                break;
            case 3: break;
        }
    }

    private void showAllUsers() {
        System.out.println();
        System.out.println("All users");
        System.out.println("========");
        HashMap<String, User> allUsers = userService.findAllUsers();
        System.out.format("| %-15s | %-15s | %-15s | %-10s |%n%n", "FIRST NAME", "SECOND NAME", "USER NAME", "ROLE");
        for (User user : allUsers.values()) {
            System.out.format("| %-15s | %-15s | %-15s | %-10s |%n", user.getFirstName(), user.getSecondName(), user.getUserName(), user.getRole());
        }
    }

    private void addUser() {
        System.out.println();
        System.out.println("Add user");
        System.out.println("========");
        String firstName = ScannerUtils.scanString("Enter first name");
        String secondName = ScannerUtils.scanString("Enter second name");
        String userName = ScannerUtils.scanString("Enter user name");
        String password = ScannerUtils.scanString("Enter password");
        Role role = ScannerUtils.scanRole("Enter role");

        userService.createUser(firstName, secondName, userName, password, role);
    }
}
