package org.example.exo2_studenthub.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.exo2_studenthub.model.Student;
import org.example.exo2_studenthub.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

//    @PostMapping("/add")
//    public boolean createStudent(@RequestBody Student student, BindingResult result){
//        return studentService.add(student);
//    }

    @PostMapping("/add/student")
    public ResponseEntity<String> createStudentWithValid(@Valid @RequestBody Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(", "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        studentService.add(student);
        return new ResponseEntity<>("Etudiant avec l'id :" + student.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteById(@PathVariable UUID id){
        return studentService.delete(id);
    }

//    @PutMapping("/update/{id}")
//    public boolean updateStudent(@PathVariable UUID id, @RequestBody Student student){
//        return studentService.update(id, student);
//    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity<String> updateStudentWithValid(@PathVariable UUID id, @Valid @RequestBody Student updateStudent, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(", "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        studentService.update(id, updateStudent);
        return new ResponseEntity<>("Modif etudiant avec l'id :" + updateStudent.getId() + " ok", HttpStatus.ACCEPTED);
    }



}
