package org.example.exo3_blog.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private UUID id;

    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "La première lettre doit être une majuscule")
    private String title;

    @NotBlank
    @Size(min = 10)
    private String description;

    @NotBlank
    private String content;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date format should be YYYY-MM-dd")
    private LocalDate date;

    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "La première lettre doit être une majuscule")
    private String authorPseudo;

    private List<Comment> commentList = new ArrayList<>();

}
