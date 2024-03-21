package com.example.backendspringsecurity.controller;

import com.example.backendspringsecurity.dto.BaseResponseDto;
import com.example.backendspringsecurity.dto.UserLoginDto;
import com.example.backendspringsecurity.model.User;
import com.example.backendspringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User newUser){
        if(userService.createUser(newUser)){
            return new BaseResponseDto("success");
        }else {
            return new BaseResponseDto("failed");
        }
    }

    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto loginDetails){
        if(userService.checkUserNameExists(loginDetails.getName())){
            if(userService.verifyUser(loginDetails.getName(), loginDetails.getPassword())){
                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(loginDetails.getName(), loginDetails.getPassword()));
                return new BaseResponseDto("success", data);
            }else {

                return new BaseResponseDto("wrong password");
            }
        }else {

            return new BaseResponseDto("user not exist");
        }
    }
}
