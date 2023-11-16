package com.example.demo3;

import javafx.collections.ObservableList;

public class UserAdmin {
    private String idAdmin;
    private String loginAdmin;
    private String passwordAdmin;
    private String firstnameAdmin;
    private String lastnameAdmin;
    private String rolA;
    public String getRolA() {
        return rolA;
    }

    public void setRolA(String rolA) {
        this.rolA = rolA;
    }



    public UserAdmin(String rolA) {
        this.rolA = rolA;
    }

    public UserAdmin(String idAdmin, String loginAdmin, String passwordAdmin, String firstnameAdmin, String lastnameAdmin, String rolA) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.passwordAdmin = passwordAdmin;
        this.firstnameAdmin = firstnameAdmin;
        this.lastnameAdmin = lastnameAdmin;
        this.rolA=rolA;

    }

    public static void setItems(ObservableList<UserAdmin> listUser) {
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getFirstnameAdmin() {
        return firstnameAdmin;
    }

    public void setFirstnameAdmin(String firstnameAdmin) {
        this.firstnameAdmin = firstnameAdmin;
    }

    public String getLastnameAdmin() {
        return lastnameAdmin;
    }

    public void setLastnameAdmin(String lastnameAdmin) {
        this.lastnameAdmin = lastnameAdmin;
    }
   // UserAdmin new_user_admin = new  UserAdmin();


}
