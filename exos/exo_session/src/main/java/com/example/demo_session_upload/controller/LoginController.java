package com.example.demo_session_upload.controller;

import com.example.demo_session_upload.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "form-log";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String login, @RequestParam String password) {
        if (loginService.login(login, password)){
            return "home-protected";
        }
        return "form-log";

    }

    @GetMapping("/homeprotected")
    public String protectedPage(){
        if(loginService.isLogged()){
            return "home-protected";
        }
        return "redirect:/login";
    }
}


