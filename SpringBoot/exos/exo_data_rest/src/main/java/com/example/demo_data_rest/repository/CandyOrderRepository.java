package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.CandyOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// http://localhost:8080/candyOrders
// http://localhost:8080/candyOrders/2/candies
@RepositoryRestResource(path = "candyOrders", collectionResourceRel = "candyOrders")
public interface CandyOrderRepository extends CrudRepository<CandyOrder, Long> {

    List<CandyOrder> findByStatus(String status);


}

