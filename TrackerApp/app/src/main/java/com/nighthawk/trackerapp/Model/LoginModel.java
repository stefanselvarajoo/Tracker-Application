package com.nighthawk.trackerapp.Model;

/**
 * Created by Michael on 11/3/17.
 */

public class LoginModel {
    private static LoginModel instance = new LoginModel();
    private String id = null;
    private String password = null;

    private LoginModel(){
    }

    public static LoginModel getInstance() {
        return instance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
