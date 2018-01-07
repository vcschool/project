package com.audrius.mivs;

import com.audrius.mivs.model.User;
import com.audrius.mivs.service.UserService;
import com.audrius.mivs.ui.AdminUserInterface;
import com.audrius.mivs.ui.UserInterface;

public class MIVS {
    public static void main(String[] args) {
        Application.initialize();
        UserInterface userInterface = null;

        User user = UserService.login();
        switch (user.getRole()) {
            case ADMIN: userInterface = new AdminUserInterface();
        }

        userInterface.open(user);
    }



}
