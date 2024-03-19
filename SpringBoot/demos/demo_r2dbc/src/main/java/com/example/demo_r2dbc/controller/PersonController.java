package com.example.demo_r2dbc.controller;

import com.example.demo_r2dbc.dao.PersonDao;
import com.example.demo_r2dbc.entity.Person;
import com.example.demo_r2dbc.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonRepository personRepository;

    public PersonController(PersonDao personDao,
                            PersonRepository personRepository) {
        this.personDao = personDao;
        this.personRepository = personRepository;
    }

    @PostMapping
    public Mono<Person> post(@RequestBody Person person) {
//        return personDao.add(person.getFirstname(), person.getLastname());
        return personRepository.save(person);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get() {
//        return personDao.getAll();
        return personRepository.findAll();
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

    @GetMapping("search/{search}")
    public Flux<Person> getPersonBySearch(@PathVariable String search){
        return personRepository.searchAllByFirstnameContainingIgnoreCase(search);
    }


}
