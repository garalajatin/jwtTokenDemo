package com.example.aopdemo.service;

import com.example.aopdemo.entity.UserEntity;
import com.example.aopdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity getUserByUserName(String userName){

        return userRepository.findByUsername(userName);
    }
}
