package org.example.exo3_blog.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.entity.Post;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

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

    private String imageUrl;

    private List<Comment> commentList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthorPseudo() {
        return authorPseudo;
    }

    public void setAuthorPseudo(String authorPseudo) {
        this.authorPseudo = authorPseudo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}