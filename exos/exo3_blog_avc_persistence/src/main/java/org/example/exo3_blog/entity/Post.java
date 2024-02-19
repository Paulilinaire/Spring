package org.example.exo3_blog.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "post_id", nullable = false)
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
    @Column(name="author_pseudo")
    private String authorPseudo;

    private String imageUrl;

    @OneToMany //(mappedBy = "post_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

}
