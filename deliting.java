package com.example.demo3;

public class deliting {
    private String name;
    private String nameId;
    private String ID;

    public deliting(String name, String nameId, String ID) {
        this.name = name;
        this.nameId = nameId;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
