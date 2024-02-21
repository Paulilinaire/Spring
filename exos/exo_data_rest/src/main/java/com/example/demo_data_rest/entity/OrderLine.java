package com.example.demo_data_rest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CandyOrder candyOrder;



    // La logique métier est embarquée dans les getters setters
    public void setCandy(Candy candy){
        this.candy = candy;
        candy.setStorage(candy.getStorage()-quantity);
    }

}
