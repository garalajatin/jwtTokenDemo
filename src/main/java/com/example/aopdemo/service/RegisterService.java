package com.example.aopdemo.service;

import com.example.aopdemo.entity.UserEntity;
import com.example.aopdemo.model.UserDTO;
import com.example.aopdemo.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    public void register(UserDTO user)  {

        //Let's check if user already registered with us
//        if(checkIfUserExist(user.getEmail())){
//            System.out.println("User already exists for this email");
//        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }



//    public boolean checkIfUserExist(String email) {
//        return userRepository.findByEmail(email);
//    }

    private void encodePassword( UserEntity userEntity, UserDTO user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}