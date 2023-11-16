package com.example.demo3;

public class UserApplication {
    private String idApplication;
    private String serviceApplication;
    private String nameServiceApplication;
    private String phoneApplication;
    private String firstnameApplication;
    private String lastnameApplication;
    private String addresApplication;
    private String checkedApplication;

    public UserApplication(String idApplication, String serviceApplication, String nameServiceApplication, String phoneApplication, String firstnameApplication, String lastnameApplication, String addresApplication, String checkedApplication) {
        this.idApplication = idApplication;
        this.serviceApplication = serviceApplication;
        this.nameServiceApplication = nameServiceApplication;
        this.phoneApplication = phoneApplication;
        this.firstnameApplication = firstnameApplication;
        this.lastnameApplication = lastnameApplication;
        this.addresApplication = addresApplication;
        this.checkedApplication = checkedApplication;
    }



    public String getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(String idApplication) {
        this.idApplication = idApplication;
    }

    public String getServiceApplication() {
        return serviceApplication;
    }

    public void setServiceApplication(String serviceApplication) {
        this.serviceApplication = serviceApplication;
    }

    public String getNameServiceApplication() {
        return nameServiceApplication;
    }

    public void setNameServiceApplication(String nameServiceApplication) {
        this.nameServiceApplication = nameServiceApplication;
    }

    public String getPhoneApplication() {
        return phoneApplication;
    }

    public void setPhoneApplication(String phoneApplication) {
        this.phoneApplication = phoneApplication;
    }

    public String getFirstnameApplication() {
        return firstnameApplication;
    }

    public void setFirstnameApplication(String firstnameApplication) {
        this.firstnameApplication = firstnameApplication;
    }

    public String getLastnameApplication() {
        return lastnameApplication;
    }

    public void setLastnameApplication(String lastnameApplication) {
        this.lastnameApplication = lastnameApplication;
    }

    public String getAddresApplication() {
        return addresApplication;
    }

    public void setAddresApplication(String addresApplication) {
        this.addresApplication = addresApplication;
    }

    public String getCheckedApplication() {
        return checkedApplication;
    }

    public void setCheckedApplication(String checkedApplication) {
        this.checkedApplication = checkedApplication;
    }



}
