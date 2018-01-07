package com.audrius.mivs.ui;

import com.audrius.mivs.model.Admin;
import com.audrius.mivs.model.User;
import com.audrius.mivs.utils.ScannerUtils;

public class AdminUserInterface implements UserInterface {
    private Admin adminUser;

    @Override
    public void open(User user) {
        this.adminUser = (Admin) user;
        System.out.println("Administration menu");
        while (true) {
            System.out.println("Hello " + adminUser.getUserName() );
            ScannerUtils.scanString();
        }
    }
}
