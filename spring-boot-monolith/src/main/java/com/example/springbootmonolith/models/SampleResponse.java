package com.example.springbootmonolith.models;

public class SampleResponse {
    private String userName;
    private String response;
    private Long id;

    public String getResponse() {
        return response;
    }

    public Long getId() {
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
