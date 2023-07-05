package com.example.aopdemo.model;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {

    public static final long serialVersionUID = 1l;

    private String username;
    private String password;

}
