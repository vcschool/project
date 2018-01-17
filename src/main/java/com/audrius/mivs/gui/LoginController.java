package com.audrius.mivs.gui;

import com.audrius.mivs.model.User;
import com.audrius.mivs.service.UserService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;

    private UserService userService = new UserService();

    public void login(ActionEvent actionEvent) throws IOException {
        User user = userService.login(userName.getText(), password.getText());

        if (user == null) {
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/admin.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Administration panel");
        stage.setScene(new Scene(fxmlLoader.load()));

        AdminController adminController = fxmlLoader.getController();
        adminController.init(user);

        stage.show();

        Stage currentScene = (Stage) loginButton.getScene().getWindow();
        currentScene.close();
    }
}
