package com.audrius.mivs.gui;

import com.audrius.mivs.model.User;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AdminController {

    @FXML
    private Text userName;

    private User user;

    public void init(User user) {
        this.user = user;
        this.userName.setText(user.getUserName());
    }
}
