package com.example.demo3;
// Авторизация

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animation.Snake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controler {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button authSiglnButton;
    @FXML
    private Button loginSignUpButton;
    @FXML
    private TextField login_field;
    @FXML
    private TextField password_field;

    static User user = new User();

    @FXML
    void initialize() {
        // кнопка с методом удаляющий пустые места
        authSiglnButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")) loginUser(loginText, loginPassword);
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Введите корректные данные!");
                alert.showAndWait();
            }

        });
    }

    public void gg(MouseEvent mouseEvent) {
        loginSignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registr.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loginUser(String loginText, String loginPassword) {

        DatabaseHandler dbHandler = new DatabaseHandler();
//User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        try {

            while (result.next()) {
                user.setrol(result.getString("rol"));
                System.out.println(result.getString("rol"));
                System.out.println(user.getrol());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //counter++;


        /**if (counter == 0) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Message");
         alert.setHeaderText(null);
         alert.setContentText("Введите корректные данные!");
         alert.showAndWait();
         } */

    }

    public void vhod(MouseEvent mouseEvent) {

        String str = new String();
        boolean prohod = true;
        System.out.println(user.getrol());
        loginSignUpButton.getScene().getWindow().hide();
        if ("admin".equals(user.getrol())) {
            str = "admin";
        } else if (user.getrol().equals("klient")) {
            str = "klient";
        } else {
            prohod = false;
        }
        if (prohod) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(str + ".fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

}
