package com.example.demo_h2database.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatDto {

    private UUID id;

    private String nickname; // name dans CatEntity

    private Date birthDate;

    private Integer age;



}
