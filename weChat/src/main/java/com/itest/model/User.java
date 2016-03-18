package com.itest.model;

/**
 * Created by Administrator on 2016/3/12.
 */
public class User {

    private String username;

    private String password;

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int checkUserValidity(String username, String password){
        if(null == username || null== password ||
                username.isEmpty() || password.isEmpty()){
            return -1;
        }
        return 0;
    }

}
