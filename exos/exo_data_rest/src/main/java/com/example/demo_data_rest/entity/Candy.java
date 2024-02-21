package com.example.demo_data_rest.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "candy")
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String name;

    private String description;

    private String magicalEffect;

    private int storage;

    private double price;

    @OneToMany(mappedBy = "candy")
    private List<Review> reviews;


}
