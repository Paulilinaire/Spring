
package org.example.exo3_blog.service;

import org.example.exo3_blog.dao.PostRepository;
import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.mapper.CommentMapper;
import org.example.exo3_blog.mapper.PostMapper;
import org.example.exo3_blog.model.PostDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
    public class PostService implements BaseService<PostDto> {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    private final CommentMapper commentMapper;


    public PostService(PostRepository postRepository, PostMapper postMapper, CommentMapper commentMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream()
                .map(postMapper::postToPostDto)
                .toList();
    }

    @Override
    public PostDto getById(UUID id) {
        return postMapper.postToPostDto(postRepository.findByIdIs(id));
    }

    @Override
    public PostDto create(PostDto postDto) {
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(postDto)));
    }

    @Override
    public PostDto update(PostDto updatedPostDto, UUID id) {
        PostDto postExists = postMapper.postToPostDto(postRepository.findByIdIs(id));
        if (postExists != null) {
            postExists.setTitle(updatedPostDto.getTitle());
            postExists.setDescription(updatedPostDto.getDescription());
            postExists.setContent(updatedPostDto.getContent());
            postExists.setImageUrl(updatedPostDto.getImageUrl());
            postExists.setAuthorPseudo(updatedPostDto.getAuthorPseudo());
        }
        return postExists;
    }

    @Override
    public void delete(UUID id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> search(String search) {
        String searchLower = search.toLowerCase();

        return postRepository.searchAllByTitle(searchLower).stream()
                .map(postMapper::postToPostDto)
                .toList();
    }

    @Override
    public boolean addCommentToPost(UUID postId, Comment comment) {
        PostDto post = postMapper.postToPostDto(postRepository.findByIdIs(postId));
        if (post != null) {
            comment.setId(UUID.randomUUID());
            post.getCommentList().add(comment);
            return true;
        }
        return false;
    }



}


