package com.example.demo_r2dbc.controller;

import com.example.demo_r2dbc.dao.PersonDao;
import com.example.demo_r2dbc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @PostMapping
    public Mono post(@RequestBody Person person) {
        return personDao.add(person.getFirstname(), person.getLastname());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get() {
        return personDao.getAll();
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") int id){
        return personDao.delete(id);
    }

    @PutMapping("{id}")
    public Mono updatePerson(@PathVariable int id,
                              @RequestBody Person person){
        return personDao.update(id, person);
    }

    @GetMapping("{id}")
    public Mono getPersonById(@PathVariable int id){
        return personDao.getById(id);
    }


}
