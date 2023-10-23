package com.example.passwordmanager;

public class PasswordModel {

    String name ;
    String pass;
    static  String pas;



    public PasswordModel(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public static String getPas(){
        return pas;
    }

    public static void setPas(String pas) {
        PasswordModel.pas = pas;
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
