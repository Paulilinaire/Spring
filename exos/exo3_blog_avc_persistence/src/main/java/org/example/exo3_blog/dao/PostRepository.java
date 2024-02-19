package org.example.exo3_blog.dao;

import org.example.exo3_blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    Post findByIdIs(UUID id);

    List<Post> searchAllByTitle(String search);

}
