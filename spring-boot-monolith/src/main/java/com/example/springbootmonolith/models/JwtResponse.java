package com.example.springbootmonolith.models;

import javax.persistence.Entity;

@Entity
public class JwtResponse {

    private String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getToken() {
        return this.jwt;
    }
}

