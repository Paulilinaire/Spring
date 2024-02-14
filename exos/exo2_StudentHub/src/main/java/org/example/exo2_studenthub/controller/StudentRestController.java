package org.example.exo2_studenthub.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.exo2_studenthub.model.Student;
import org.example.exo2_studenthub.service.BaseService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteById(@PathVariable UUID id){
        return studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public boolean updateStudent(@PathVariable UUID id, Student student){
        return studentService.update(id, student);
    }

}
