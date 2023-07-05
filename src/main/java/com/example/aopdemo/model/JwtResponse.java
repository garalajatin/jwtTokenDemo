package com.example.aopdemo.model;

import lombok.*;

import java.io.Serializable;



public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1l;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
