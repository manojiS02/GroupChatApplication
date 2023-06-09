package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUsername;
    public Button btnLogin;
    public static String name;

    public void OnActionUsername(ActionEvent actionEvent) {
        btnLogin.fire();
    }

    public void OnActionLogin(ActionEvent actionEvent) throws IOException {
        name = txtUsername.getText();
        Parent root = FXMLLoader.load(getClass().getResource("../view/ChatForm.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Live Chat");
        stage.getIcons().add(new Image("assets/img/icons8-message-64.png"));

        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();


        txtUsername.clear();

    }
}
