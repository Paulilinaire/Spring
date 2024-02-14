package org.example.exo2_studenthub.controller;

import org.example.exo2_studenthub.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.exo2_studenthub.model.Student;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    private final BaseService<Student> studentService;

    public StudentController(@Qualifier("student") BaseService<Student> studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String homePage() {
        return "homepage";
    }


    @GetMapping("/list")
    public String listingStudents(Model model){
        List<Student> students = studentService.getAll();
        Student student = students.get(0);
        model.addAttribute("idStudent",student.getId());

        model.addAttribute("students",students);
        return "student/list";
    }


    @GetMapping("/detail/{studentId}")
    public String detailStudent(@PathVariable("studentId") UUID id, Model model){
        Student student = studentService.getByID(id);
        model.addAttribute("student",student);
        return "student/details";
    }


    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());

        return "addstudent";
    }

    @PostMapping("/add")
    public String submitStudent(@ModelAttribute("student") Student student){
        studentService.add(student);
        return "redirect:list";
    }

    @GetMapping("/look")
    public String showStudent(@RequestParam(value = "namestudent", required = false) String name, Model model){
        List<Student> students = studentService.getByLastNameAndFirstNameIgnoreCase(name);

        if(!students.isEmpty()){
            model.addAttribute("students", students);
            return "student/searchresult";
        } else {
            return "student/error";
        }
    }


}
