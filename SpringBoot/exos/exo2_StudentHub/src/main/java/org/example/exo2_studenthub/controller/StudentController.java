package org.example.exo2_studenthub.controller;

import jakarta.validation.Valid;
import org.example.exo2_studenthub.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.example.exo2_studenthub.model.Student;

import java.util.UUID;

@Controller
public class StudentController {

    private final BaseService<Student> studentService;

    @Value("${academy.name}")
    private String academyName;

    @Value("${academy.contact}")
    private String academyContact;

    public StudentController(@Qualifier("student") BaseService<Student> studentService) {
        this.studentService = studentService;
    }

    @GetMapping // http://localhost:8080
    public String homePage(Model model) {
        model.addAttribute("name", academyName);
        model.addAttribute("contact", academyContact);
        return "homepage";
    }


    @GetMapping("/students")
    public String listingStudents(@RequestParam(name = "search", required = false) String search, Model model){
        if (search == null){
            model.addAttribute("students", studentService.getAll());
        } else {
            model.addAttribute("students", studentService.searchStudent(search));
        }
        return "student/list";
    }


    @GetMapping("/details/{id}")
    public String detailStudent(@PathVariable("id") UUID id, Model model){
        model.addAttribute("student", studentService.getById(id));
        return "student/details";
    }


    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping("/add")
    public String submitStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "student-form";
        }
        studentService.add(student);
        return "redirect:/students";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable(name = "id") UUID id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student-form";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable(name = "id") UUID id, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "student-form";
        }
        studentService.update(id, student);
        return "redirect:/students";
    }


    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable (name = "id") UUID id) {
        studentService.delete(id);
        return "redirect:/students";
    }


}