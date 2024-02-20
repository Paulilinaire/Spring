package org.example.exo3_blog.service;

import org.example.exo3_blog.entity.Comment;

import java.util.List;
import java.util.UUID;


public interface BaseService<T> {

    List<T> getAll();
    T getById(UUID id);
    T create(T element);
    T update(T element, UUID id);
    void delete(UUID id);
    List<T> search(String search);


    boolean addCommentToPost(UUID postId, Comment comment);

}
