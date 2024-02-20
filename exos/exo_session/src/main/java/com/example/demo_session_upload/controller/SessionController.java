package com.example.demo_session_upload.controller;

import com.example.demo_session_upload.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SessionController {

    @Autowired
    private HttpSession _httpSession;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginForm() {
        return "form-log";
    }

    @GetMapping("/log")
    public String redirectToHomeOrLoginForm() {
        String username = _httpSession.getAttribute("username") != null ?
                _httpSession.getAttribute("username").toString() : null;

        if (username != null) {
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }
}


