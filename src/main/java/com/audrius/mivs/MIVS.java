package com.audrius.mivs;

import com.audrius.mivs.model.User;
import com.audrius.mivs.service.UserService;
import com.audrius.mivs.ui.admin.AdminUserInterface;
import com.audrius.mivs.ui.UserInterface;

public class MIVS {
    public static void main(String[] args) {
        Application.initialize();
        UserInterface userInterface = null;

        while (true) {
            User user = new UserService().login();
            switch (user.getRole()) {
                case ADMIN:
                    userInterface = new AdminUserInterface();
            }

            userInterface.openMainMenu(user);
        }
    }
}
