package com.example.aopdemo.security;

import com.example.aopdemo.entity.UserEntity;
import com.example.aopdemo.model.UserDTO;
import com.example.aopdemo.repo.UserRepository;
import com.example.aopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("root".equals(username)) {
//            return new User("root", "$2a$10$P3gJfhaezpcOGF552hMPI.A4Y1gfx1ynwjm4Ws7t0.FmZqK6NXKzG",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }

        UserEntity userEntity = userService.getUserByUserName(username);

        return new User(userEntity.getUsername(), userEntity.getPassword(),new ArrayList<>());

    }

}
