package com.example.demo_r2dbc.repository;

import com.example.demo_r2dbc.entity.Address;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AddressRepository extends R2dbcRepository<Address, Long> {

    @Query("SELECT a.id, a.full_Address, p.id, p.firstname, p.lastname from address as a inner join person as p on a.person_Id = p.id where a.id = :id")
    Mono<Address> findAddressByIdWithPerson(long id);


}
