package com.example.demo3;

public class UserService {
    private String id_services;
    private  String typeService_services;
    private  String nameService_services;
    private String  dueDate_services;
    private String price_services;


    public UserService(String id_services, String typeService_services, String nameService_services, String dueDate_services, String price_services) {
        this.id_services = id_services;
        this.typeService_services = typeService_services;
        this.nameService_services = nameService_services;
        this.dueDate_services = dueDate_services;
        this.price_services = price_services;
    }

    public String getId_services() {
        return id_services;
    }

    public void setId_services(String id_services) {
        this.id_services = id_services;
    }

    public String getTypeService_services() {
        return typeService_services;
    }

    public void setTypeService_services(String typeService_services) {
        this.typeService_services = typeService_services;
    }

    public String getNameService_services() {
        return nameService_services;
    }

    public void setNameService_services(String nameService_services) {
        this.nameService_services = nameService_services;
    }

    public String getDueDate_services() {
        return dueDate_services;
    }

    public void setDueDate_services(String dueDate_services) {
        this.dueDate_services = dueDate_services;
    }

    public String getPrice_services() {
        return price_services;
    }

    public void setPrice_services(String price_services) {
        this.price_services = price_services;
    }

}
