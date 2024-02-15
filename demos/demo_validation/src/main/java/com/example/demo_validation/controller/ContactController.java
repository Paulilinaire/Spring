package com.example.demo_validation.controller;


import com.example.demo_validation.model.Contact;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    // ATTENTION SANS ANNOTATION VALID CA NE MARCHERA PAS
    @PostMapping("/add")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult){ // ModelAttribute car on récupère le new Contact du get au-dessus
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "form-confirm";
    }
}
