package com.example.demo3;
//Регистрация
public class User {
    private String firstName;
    private  String lastName;
    private  String username;
    private String  password;
    private String rol;
    // метод позволяющий вытягивать данные из класса


    public User(String firstName, String lastName, String username, String password,String rol) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setrol(String rol) {
        this.rol = rol;
    }
    public String getrol() {
        return rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
