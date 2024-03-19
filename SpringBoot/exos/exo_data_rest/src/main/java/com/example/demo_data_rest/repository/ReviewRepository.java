package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.Candy;
import com.example.demo_data_rest.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// http://localhost:8080/review

@RepositoryRestResource(path = "reviews", collectionResourceRel = "reviews")
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByCandy(@Param("candy") Candy candy);


}
