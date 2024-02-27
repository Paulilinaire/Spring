package com.example.demo_r2dbc.controller;

import com.example.demo_r2dbc.entity.Address;
import com.example.demo_r2dbc.entity.Person;
import com.example.demo_r2dbc.repository.AddressRepository;
import com.example.demo_r2dbc.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressController(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("{id}")

    public Mono<Address> get(@PathVariable("id") long id) {
        return addressRepository.findById(id).flatMap(address ->
                personRepository.findById((long) address.getPersonId())
                        .map(p->  {
                            address.setPerson(p);
                            return address;
                        })
        );
    }

    @PostMapping
    public Mono<Address> post(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("second/{id}")
    public Mono<Address> secondGet(@PathVariable("id") long id) {
        return addressRepository.findAddressByIdWithPerson(id);
    }
}
