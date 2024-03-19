package com.example.demo_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "candy_order")
public class CandyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDate date;

    @OneToMany(mappedBy = "candyOrder")
    private List<OrderLine> orderLines;


    public void markAsNew() { this.status = "NEW"; }
    public void markAsCurrent() {
        this.status = "CURRENT";
    }
    public void markAsDelivered() {
        this.status = "DELIVERED";
    }

}
