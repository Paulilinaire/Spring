
package org.example.exo3_blog.service;

import org.example.exo3_blog.dao.PostRepository;
import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

    @Service
    public class PostService implements BaseService<Post> {

        private PostRepository postRepository;

        public PostService(PostRepository postRepository) {
            this.postRepository = postRepository;
        }

        @Override
        public List<Post> getAll() {
            return new ArrayList<>(postRepository.findAll());
        }

        @Override
        public Post getById(UUID id) {
            return postRepository.findByIdIs(id);
        }

        @Override
        public Post create(Post post) {
            return postRepository.save(post);
        }

        @Override
        public Post update(Post updatedPost, UUID id) {
            Post postExists = postRepository.findByIdIs(id);
            if (postExists != null) {
                postExists.setTitle(updatedPost.getTitle());
                postExists.setDescription(updatedPost.getDescription());
                postExists.setContent(updatedPost.getContent());
                postExists.setImageUrl(updatedPost.getImageUrl());
                postExists.setAuthorPseudo(updatedPost.getAuthorPseudo());
                }
            return postExists;
        }

        @Override
        public void delete(UUID id) {
            postRepository.deleteById(id);
        }

        @Override
        public List<Post> search(String search) {
            String searchLower = search.toLowerCase();

            return postRepository.searchAllByTitle(search)
                    .stream()
                    .filter(post ->
                            post.getTitle().toLowerCase().contains(searchLower))
                    .toList();
        }


        @Override
        public boolean addCommentToPost(UUID postId, Comment comment) {
            Post post = postRepository.findByIdIs(postId);
            if (post != null) {
                comment.setId(UUID.randomUUID());
                post.getCommentList().add(comment);
                return true;
            }
            return false;
        }




    }


