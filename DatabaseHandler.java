package com.example.demo3;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
// база данных

public class DatabaseHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    // метод записывающий пользователей в базу данных
    public void sinUpUser(User user) {
        // SQL запрос устанавливающий данные
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD +",rol" +")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5,"klient");

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public ObservableList<UserAdmin> Get_All_Users() {
        String request = "SELECT * FROM  users ";
        ObservableList<UserAdmin> list_users = FXCollections.observableArrayList();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);

            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                list_users.add(new UserAdmin(resultSet.getString("idusers"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("username"), resultSet.getString("password"), "KLIENT "));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list_users;
    }

    public void New_And_Uptend_Users(UserAdmin new_user, String sender) {
        String request = null;
        request = "INSERT INTO users( idusers ,  firstname, lastname ,  username , password, rol) VALUE(?,?,?,?,?,?)";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(request);
            prST.setString(1, new_user.getIdAdmin());
            prST.setString(2, new_user.getFirstnameAdmin());
            prST.setString(3, new_user.getLastnameAdmin());
            prST.setString(4, new_user.getLoginAdmin());
            prST.setString(5, new_user.getPasswordAdmin());
            prST.setString(6, new_user.getRolA());
            System.out.println(new_user.getRolA());

            prST.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<UserApplication> Get_All_Users_Application() {
        String requestA = "SELECT * FROM application";
        ObservableList<UserApplication> list_users_application = FXCollections.observableArrayList();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(requestA);

            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                list_users_application.add(new UserApplication(resultSet.getString("idapplication"), resultSet.getString("service_applicationcol"),
                        resultSet.getString("nameService_application"), resultSet.getString("phone_application"), resultSet.getString("firstname_application"), resultSet.getString("lastname_application"),
                        resultSet.getString("addres_application"), resultSet.getString("checked_application")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list_users_application;
    }

    public void New_And_Uptend_Users_Application(UserApplication new_user) {
        String request = null;
        System.out.println("1");
        String requestA = "INSERT INTO application (idapplication, service_applicationcol, nameService_application ,  phone_application , firstname_application,lastname_application,addres_application,checked_application) VALUE(?,?,?,?,?,?,?,?)";
        System.out.println("1");
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(requestA);
            prST.setString(1, new_user.getIdApplication());
            prST.setString(2, new_user.getServiceApplication());
            prST.setString(3, new_user.getNameServiceApplication());
            prST.setString(4, new_user.getPhoneApplication());
            prST.setString(5, new_user.getFirstnameApplication());
            prST.setString(6, new_user.getLastnameApplication());
            prST.setString(7, new_user.getAddresApplication());
            prST.setString(8, new_user.getCheckedApplication());

            prST.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ObservableList<UserService> Get_All_Users_Service() {
        String request = "SELECT * FROM  service ";
        ObservableList<UserService> list_users_service = FXCollections.observableArrayList();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);

            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                list_users_service.add(new UserService(resultSet.getString("idservice"), resultSet.getString("typeService_services"),
                        resultSet.getString("nameService_services"), resultSet.getString("dueDate_services"), resultSet.getString("price_services")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list_users_service;
    }
    public void New_And_Uptend_Users_Service(UserService new_user, String sender) {
        String request = null;
        System.out.println("1");
        request = "INSERT INTO service( idservice ,  typeService_services, nameService_services ,  dueDate_services , price_services) VALUE(?,?,?,?,?)";
        System.out.println("2");
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(request);
            System.out.println("3");
            prST.setString(1, new_user.getId_services());
            System.out.println("4");
            prST.setString(2, new_user.getTypeService_services());
            System.out.println("5");
            prST.setString(3, new_user.getNameService_services());
            System.out.println("6");
            prST.setString(4, new_user.getDueDate_services());
            System.out.println("7");
            prST.setString(5, new_user.getPrice_services());
            System.out.println("8");

            prST.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletingLine (deliting deleting) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM " + deleting.getName() + " WHERE "+ deleting.getNameId()+" = " + deleting.getID() +";";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }

}
