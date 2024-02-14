package org.example.exo2_studenthub.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.exo2_studenthub.model.Student;
import org.example.exo2_studenthub.service.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/academy")
@AllArgsConstructor
public class StudentRestController {

    private final BaseService<Student> studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") UUID id){
        return studentService.getById(id);
    }
}
