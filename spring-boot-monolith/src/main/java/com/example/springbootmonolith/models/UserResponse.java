package com.example.springbootmonolith.models;

public class UserResponse {
    private Long id;
    private String response;

    public Long getId(){
        return id;
    }

    public String getResponse(){
        return response;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setResponse(String response){
        this.response = response;
    }

}
