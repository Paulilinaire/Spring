package org.example.exo2_studenthub.service;

import lombok.RequiredArgsConstructor;
import org.example.exo2_studenthub.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("student")
public class StudentService implements BaseService<Student>{

    private final Map<UUID, Student> students;


    public StudentService() {
        students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Turner")
                .firstname("William")
                .age(17)
                .email("w.turner@gmail.com")
                .phone("0641789635")
                .build();
        students.put(studentA.getId(), studentA);

        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Smith")
                .firstname("Emma")
                .age(18)
                .email("e.smith@gmail.com")
                .phone("0641779635")
                .build();
        students.put(studentB.getId(), studentB);

        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Jones")
                .firstname("James")
                .age(19)
                .email("j.jones@gmail.com")
                .phone("0771789635")
                .build();
        students.put(studentC.getId(), studentC);

        Student studentD = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Davis")
                .firstname("Olivia")
                .age(20)
                .email("o.davis@gmail.com")
                .phone("0784189635")
                .build();
        students.put(studentD.getId(), studentD);

        Student studentE = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Nguyen")
                .firstname("Sophia")
                .age(21)
                .email("s.nguyen@gmail.com")
                .phone("0641789644")
                .build();
        students.put(studentE.getId(), studentE);

        Student studentF = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Smith")
                .firstname("Frankie")
                .age(18)
                .email("s.frankie@gmail.com")
                .phone("0641789666")
                .build();
        students.put(studentF.getId(), studentF);

        Student studentG = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Johnson")
                .firstname("Jane")
                .age(18)
                .email("j.jane@gmail.com")
                .phone("0641789789")
                .build();
        students.put(studentG.getId(), studentG);
    }


    @Override
    public List<Student> getAll() {
        return students.values().stream().toList();
    }

    @Override
    public Student getById(UUID id) {
        return students.values().stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean add(Student student) {
        if(student.getId() == null ){
            student.setId(UUID.randomUUID());
            students.put(student.getId(),student);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(UUID id) {
        if(id != null && students.containsKey(id)) {
            students.remove(id);
            return true;
        } else {
            return false;
        }
    }



    @Override
    public List<Student> getByLastName(String lastname) {
        return students.values()
                .stream()
                .filter(s -> s.getLastname().equalsIgnoreCase(lastname))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> searchStudent(String search) {
        String searchLower = search.toLowerCase();

        return students
                .values()
                .stream()
                .filter(student ->
                        student.getLastname().toLowerCase().contains(searchLower) ||
                                student.getFirstname().toLowerCase().contains(searchLower))
                .toList();
    }



}
