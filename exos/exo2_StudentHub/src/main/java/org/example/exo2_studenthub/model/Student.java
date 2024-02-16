package org.example.exo2_studenthub.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private UUID id;

    @NotBlank
    @Size(min=3, message = "3 lettres minimum")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "La première lettre doit être une majuscule")
    private String lastname;

    @NotBlank
    @Size(min=3, message = "3 lettres minimum")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "La première lettre doit être une majuscule")
    private String firstname;

    @Min(16)
    @Max(60)
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "L'adresse doit être au format email name@example.com")
    private String email;

    @Size(min=10, max=15)
    private String phone;

}
