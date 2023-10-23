package com.example.passwordmanager;

public class PasswordModel {

    String name ;
    String pass;

    public PasswordModel(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public PasswordModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
