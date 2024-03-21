package com.m2ibank.controller;

import com.m2ibank.dto.BaseResponceDto;
import com.m2ibank.dto.UserLoginDto;
import com.m2ibank.model.Customer;
import com.m2ibank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/auth/register")
    public BaseResponceDto registerUser(@RequestBody Customer newCustomer){
        if(customerService.createUser(newCustomer)){
            return new BaseResponceDto("success");
        }else {
            return new BaseResponceDto("failed");
        }
    }

    @PostMapping("/auth/login")
    public BaseResponceDto loginUser(@RequestBody UserLoginDto loginDetails){
        if(customerService.checkUserNameExists(loginDetails.getEmail())){
            if(customerService.verifyCustomer(loginDetails.getEmail(), loginDetails.getPwd())){
                Map<String, Object> data = new HashMap<>();
                data.put("token", customerService.generateToken(loginDetails.getEmail(), loginDetails.getPwd()));
                return new BaseResponceDto("success", data);
            }else {
                return new BaseResponceDto("wrong password");
            }
        }else {
            return new BaseResponceDto("user not exist");
        }
    }


}
