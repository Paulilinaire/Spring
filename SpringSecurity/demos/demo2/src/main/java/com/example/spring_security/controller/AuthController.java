package com.example.spring_security.controller;

import com.example.spring_security.dto.BaseResponseDto;
import com.example.spring_security.dto.UserLoginDto;
import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User user){
        if(userService.createUser(user)){
            return new BaseResponseDto("success");
        } else {
            return new BaseResponseDto("failed");
        }
    }

    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto){ // la méthode Login doit retourné un token pour que l'accés soit authorized
        if(userService.checkUsernameExists(userLoginDto.getEmail())){
            if(userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword())){
                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));

                return new BaseResponseDto("success", data);

            } else {
                return new BaseResponseDto("wrong password");
            }

        } else {
            return new BaseResponseDto("user not found");
        }
    }



}
