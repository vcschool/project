package com.audrius.mivs;

import com.audrius.mivs.model.User;
import com.audrius.mivs.service.UserService;
import com.audrius.mivs.ui.admin.AdminUserInterface;
import com.audrius.mivs.ui.UserInterface;

public class MIVS {
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        Application.initialize();
        UserInterface userInterface = null;

        while (true) {
            User user = userService.login();
            switch (user.getRole()) {
                case ADMIN:
                    userInterface = new AdminUserInterface();
            }

            userInterface.openMainMenu(user);
        }
    }
}
