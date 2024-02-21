package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// http://localhost:8080/candyOrders/OrderLine/1
// http://localhost:8080/candyOrders/OrderLine
@RepositoryRestResource(path = "orderLines", collectionResourceRel = "orderLines")
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {



}
