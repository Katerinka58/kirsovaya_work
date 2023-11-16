package com.example.demo3;
// admin
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Admin {
    @FXML
    private TextField  ID_application;
    public TableView<UserService> table_service;
    public TableView<UserAdmin> table_Admin;

    public TableView <UserApplication>table_application;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<UserApplication, String> addres_table_application;

    @FXML
    private Button checkedButtonApplication;

    @FXML
    private TableColumn<UserApplication, String> checked_table_application;

    @FXML
    private Button dellButton;

    @FXML
    private Button dellButtonApplication;

    @FXML
    private TextField dueDate_services;

    @FXML
    private TableColumn<UserService, String> dueDate_table_services;

    @FXML
    private TextField firstname_admin;

    @FXML
    private TableColumn<UserAdmin, String> firstname_table_admin;

    @FXML
    private TableColumn<UserApplication, String> firstname_table_application;

    @FXML
    private TextField id_Admin;

    @FXML
    private TextField id_services;

    @FXML
    private TableColumn<UserAdmin, String> id_table_admin;

    @FXML
    private TableColumn<UserApplication, String> id_table_application;

    @FXML
    private TableColumn<UserService, String> id_table_services;

    @FXML
    private TextField lastname_admin;

    @FXML
    private TableColumn<UserAdmin, String> lastname_table_admin;

    @FXML
    private TableColumn<UserApplication, String> lastname_table_application;

    @FXML
    private TextField login_admin;

    @FXML
    private TableColumn<UserAdmin, String> login_table_admin;

    @FXML
    private TextField nameService_services;

    @FXML
    private TableColumn<UserApplication, String> nameService_table_Application;

    @FXML
    private TableColumn<UserService, String> nameService_table_services;

    @FXML
    private Button outputButton;

    @FXML
    private TextField password_admin;

    @FXML
    private TableColumn<UserAdmin, String> password_table_admin;

    @FXML
    private TableColumn<UserApplication, String> phone_table_application;

    @FXML
    private TextField price_services;

    @FXML
    private TableColumn<UserService,String> price_table_services;

    @FXML
    private TableColumn<UserApplication, String> service_table_application;

    @FXML
    private TextField typeService_services;

    @FXML
    private TableColumn<UserService, String> typeService_table_services;
    DatabaseHandler dbHA = new DatabaseHandler();

    @FXML
    void initialize() {
        dellButton.setOnAction(event -> {
            try {
                deletingAdmin();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        checkedButtonApplication.setOnAction(event -> {
            try {
                deletingId();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        Zapolnenie_User();
        Zapolnenie_User_Application();
        Zapolnenie_User_Service();

    }
   private void signUpAdmin(){
       String id_table_admin = id_Admin.getText() ;
       String login_table_admin = login_admin.getText();
       String password_table_admin = password_admin.getText();
       String firstname_table_admin = firstname_admin.getText();
       String lastname_table_admin = lastname_admin.getText();
//UserAdmin userA = new UserAdmin(id_table_admin,login_table_admin,password_table_admin,firstname_table_admin,lastname_table_admin,"klient");
   }
   // метод заполнения таблицы "Аккаунт"
   public void Zapolnenie_User (){
       ObservableList<UserAdmin> list_user = dbHA.Get_All_Users();
       id_table_admin.setCellValueFactory(new PropertyValueFactory <UserAdmin,String>("idAdmin"));
       login_table_admin.setCellValueFactory(new PropertyValueFactory <UserAdmin,String>("loginAdmin"));
       password_table_admin.setCellValueFactory(new PropertyValueFactory <UserAdmin,String>("passwordAdmin"));
       firstname_table_admin.setCellValueFactory(new PropertyValueFactory <UserAdmin,String>("firstnameAdmin"));
       lastname_table_admin.setCellValueFactory(new PropertyValueFactory <UserAdmin,String>("lastnameAdmin"));

       table_Admin.setItems(list_user);}
    //  Реализация Кнопки назад
    public void latter(MouseEvent mouseEvent) {
        outputButton.getScene().getWindow().hide();
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
    //  Метод удаления зарегистрированой заявки в таблице "Акаунт"
    private void deletingAdmin() throws SQLException, ClassNotFoundException {


        String name = " users ";
        String nameId= " idusers ";
        String ID = id_Admin.getText();

        if(!id_Admin.getText().isEmpty()){

            deliting deleting = new deliting(name,nameId, ID);
            dbHA.deletingLine(deleting);
            System.out.println("elfkbkcz");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Пользователь удалён.");
            alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Проверьте коректность данных." +
                            "(Поле с ID должно быть заполнено)");
            alert.showAndWait();

        }

    }
    // Реализация кнопки "Добавить" в таблице "Акаунт" (1 таблица)
    public void add(MouseEvent mouseEvent) {
        if(!id_Admin.getText().isEmpty() && !login_admin.getText().isEmpty() && !password_admin.getText().isEmpty() && !firstname_admin.getText().isEmpty() && !lastname_admin.getText().isEmpty()){
            dbHA.New_And_Uptend_Users(new UserAdmin(id_Admin.getText().trim(), login_admin.getText().trim(), password_admin.getText().trim(),firstname_admin.getText().trim(),lastname_admin.getText().trim(),"klient")
                    ,"2");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Окно");
            alert.setHeaderText(null);
            alert.setContentText("Пользователь добавлен!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Проверьте коректность данных." +
                    "(Все поля  должны быть заполнены)");
            alert.showAndWait();
        } Zapolnenie_User();
    }


    // Заполнение таблицы "Заявки" (2 таблица)
    public void Zapolnenie_User_Application (){
        ObservableList <UserApplication> list_user_application = dbHA.Get_All_Users_Application();

        id_table_application.setCellValueFactory(new PropertyValueFactory<UserApplication,String>("idApplication"));
        service_table_application.setCellValueFactory(new PropertyValueFactory <UserApplication,String>("serviceApplication"));
        nameService_table_Application.setCellValueFactory(new PropertyValueFactory <UserApplication,String>("nameServiceApplication"));
        phone_table_application.setCellValueFactory(new PropertyValueFactory <UserApplication,String>("phoneApplication"));
        firstname_table_application.setCellValueFactory(new PropertyValueFactory <UserApplication,String>("firstnameApplication"));
        lastname_table_application.setCellValueFactory(new  PropertyValueFactory<UserApplication,String>("lastnameApplication"));
        addres_table_application.setCellValueFactory(new PropertyValueFactory<UserApplication,String>("addresApplication"));
        checked_table_application.setCellValueFactory(new  PropertyValueFactory<UserApplication,String>("checkedApplication"));

        table_application.setItems(list_user_application);
    }
    //удаление аккаунта
    @FXML
    private void deletingId() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHA = new DatabaseHandler();

        String name = "application";
        String nameId= "idapplication";
        String ID = ID_application.getText();

        if(!id_table_application.equals("")){
            System.out.println("Произошло нажатие");
            deliting deliting = new deliting(name,nameId, ID);
            dbHA.deletingLine(deliting);
            System.out.println("удалён");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Пользователь проверен.");
                alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Проверьте коректность данных." +
                            "(Только поле с ID должно быть заполнено)");
            alert.showAndWait();

        } Zapolnenie_User_Application();
        System.out.println("заполнение произошло");
    }


    // Заполнение таблицы "Зарегистрировать заявку"  (3 таблица)

    public void Zapolnenie_User_Service (){
        ObservableList <UserService> list_users_service = dbHA.Get_All_Users_Service();
        id_table_services.setCellValueFactory(new PropertyValueFactory <UserService,String>("id_services"));
        typeService_table_services.setCellValueFactory(new PropertyValueFactory <UserService,String>("typeService_services"));
        nameService_table_services.setCellValueFactory(new PropertyValueFactory <UserService,String>("nameService_services"));
        dueDate_table_services.setCellValueFactory(new PropertyValueFactory <UserService,String>("dueDate_services"));
        price_table_services.setCellValueFactory(new PropertyValueFactory <UserService,String>("price_services"));

        table_service.setItems(list_users_service);}
    public void dell(MouseEvent mouseEvent) {}

    public void add_application(MouseEvent mouseEvent) {
        if (!id_services.getText().isEmpty() && !typeService_services.getText().isEmpty() && !nameService_services.getText().isEmpty() && !dueDate_services.getText().isEmpty() && !price_services.getText().isEmpty()){
            dbHA.New_And_Uptend_Users_Service(new UserService(id_services.getText().trim(), typeService_services.getText().trim(), nameService_services.getText().trim(),dueDate_services.getText().trim(),price_services.getText().trim())
                    ,"2");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Окно");
            alert.setHeaderText(null);
            alert.setContentText("Услуга зарегистрирована!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Проверьте коректность данных." +
                    "(Все поля  должны быть заполнены)");
            alert.showAndWait();
        }  Zapolnenie_User_Service();
    }
}
