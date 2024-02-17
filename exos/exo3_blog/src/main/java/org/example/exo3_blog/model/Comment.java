package org.example.exo3_blog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private UUID id;

    @NotBlank
    @Size(min = 3)
    private String username;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "L'adresse doit être au format email name@example.com")
    private String email;

    @NotBlank
    @Size(min = 3, max = 300)
    private String content;

    private LocalDate date;

    private LocalTime time;

}
