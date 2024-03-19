package com.example.demo_validation.model;

import com.example.demo_validation.validation.MyValid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NotBlank
    @NotNull //jakarta.validation.constraints
    @MyValid(value = "za", message = "on avait dit za") //validation personnalisée
    private String firstname;

    @Size(min=3, message = "3 minimum")
    @NotNull(message = "j'ai dit, pas null!")
    private String lastname;

    @Min(3)
    @Max(42)
    private Integer age; // Integer est un rapport, @valid fonctionne seulement sur les wrappers


}
