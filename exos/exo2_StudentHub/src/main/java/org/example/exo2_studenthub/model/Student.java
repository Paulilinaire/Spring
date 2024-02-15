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
    @Pattern(regexp = "^[A-Z][a-z]*$") // first letter in capital letter
    private String lastname;

    @NotBlank
    @Size(min=3, message = "3 lettres minimum")
    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstname;

    @Min(16)
    @Max(60)
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Size(min=10, max=15)
    private String phone;

}
