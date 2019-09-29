package com.example.springbootmonolith.models;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.UserController.UserController;

public class UserResponse {
    private String userName;
    private String response;

    public String getUserName(){
        return userName;
    }

    public String getResponse(){
        return response;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setResponse(String response){
        this.response = response;
    }

}
