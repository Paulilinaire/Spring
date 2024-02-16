package org.example.exo3_blog.service;

import org.example.exo3_blog.model.Comment;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    List<T> getAll();
    T getById(UUID id);
    boolean create(T element);
    List<T> search(String search);

    List<Comment> getCommentsForPost(UUID postId);
    boolean addCommentToPost(UUID postId, Comment comment);

}
