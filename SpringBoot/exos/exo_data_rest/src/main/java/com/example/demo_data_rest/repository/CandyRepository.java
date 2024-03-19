package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


// http://localhost:8080/candy
@RepositoryRestResource(path = "candies", collectionResourceRel = "candies")
public interface CandyRepository extends CrudRepository<Candy, Long> {


//    @RestResource(path = "searchname") : give a name to our path
    List<Candy> findAllByName(@Param("name") String name);

    List<Candy> findAllByMagicalEffect(String magicalEffect);

    List<Candy> findAllByPriceBetween(double minPrice, double maxPrice);




}
