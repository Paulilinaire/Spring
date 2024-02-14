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

    @GetMapping // http://localhost:8080
    public String homePage() {
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
        return "addstudent";
    }

    @PostMapping("/add")
    public String submitStudent(@ModelAttribute("student") Student student){
        studentService.add(student);
        return "redirect:students";
    }


//    @GetMapping("/look")
//    public String showStudent(@RequestParam(value = "namestudent", required = false) String name, Model model){
//        List<Student> students = studentService.searchStudent(name);
//
//        if(!students.isEmpty()){
//            model.addAttribute("students", students);
//            return "student/searchresult";
//        } else {
//            return "student/error";
//        }
//    }

    @DeleteMapping(value = "/delete/{studentId}")
    public String deleteById(@PathVariable("studentId") UUID studentId){
        studentService.delete(studentId);
        return "redirect:list";
    }


}
