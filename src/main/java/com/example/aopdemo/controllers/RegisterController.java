package com.example.aopdemo.controllers;

import com.example.aopdemo.model.UserDTO;
import com.example.aopdemo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public String userRegistration(@RequestBody UserDTO userDto){

        try {
            registerService.register(userDto);
        }catch (Exception e){

            return "failure";
        }
        return "success";
    }
}
