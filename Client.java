package com.example.demo3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Client {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField addres_application;

        @FXML
        private MenuButton applicationAButton;

        @FXML
        private TextField comment_application;

        @FXML
        private Button dubButton;

        @FXML
        private TextField lactname_application;

        @FXML
        private TextField name_application;

        @FXML
        private Button nextButton;

        @FXML
        private TextField telechon_application;

        String serviceApplication;

        @FXML
        void initialize() {

            applicationAButton.getItems().forEach(item -> {
                item.setOnAction(event -> {

                    // код, который отображает выбранную услугу
                    serviceApplication = item.getText();
                    System.out.println("Выбранная услуга: " + item.getText());
                    // Пример: отобразить выбранную услугу в текстовом поле или другом элементе интерфейса
                });
            });


        }


        public void add(MouseEvent mouseEvent) {
            DatabaseHandler dbHandler = new DatabaseHandler();

            if (!name_application.getText().isEmpty() && !telechon_application.getText().isEmpty() && !lactname_application.getText().isEmpty() && !addres_application.getText().isEmpty() && !comment_application.getText().isEmpty()) {


                String nameServiceApplication = comment_application.getText();
                String phoneApplication = telechon_application.getText();
                String firstnameApplication = name_application.getText();
                String lastnameApplication = lactname_application.getText();
                String addresApplication = addres_application.getText();
                UserApplication user = new UserApplication("0", serviceApplication, nameServiceApplication, phoneApplication, firstnameApplication, lastnameApplication, addresApplication, "Не проверено");

                dbHandler.New_And_Uptend_Users_Application(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Вы зарегистрировали заявку!");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ошибка! Все поля должны быть заполнены!");
                alert.showAndWait();
            }

        }
    public void  latter (MouseEvent mouseEvent) {
        nextButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("avtoriz.fxml"));
        try {
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    }