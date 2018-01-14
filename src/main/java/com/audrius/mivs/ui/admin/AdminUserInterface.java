package com.audrius.mivs.ui.admin;

import com.audrius.mivs.model.User;
import com.audrius.mivs.ui.UserInterface;
import com.audrius.mivs.utils.ScannerUtils;

public class AdminUserInterface implements UserInterface {
    private boolean logged = true;

    private UsersManagementMenu usersManagementMenu = new UsersManagementMenu();
    private CourseManagementMenu courseManagementMenu = new CourseManagementMenu();

    @Override
    public void openMainMenu(User user) {
        while (logged) {
            System.out.println();
            System.out.println("Administration menu");
            System.out.println("===================");
            System.out.println("1. Manage users");
            System.out.println("2. Manage courses");
            System.out.println("3. Log out");

            int choice = ScannerUtils.scanInt(1, 3);

            switch (choice) {
                case 1:
                    usersManagementMenu.open();
                    break;
                case 2:
                    courseManagementMenu.open();
                    break;
                case 3: logged = false;
            }
        }
    }
}
