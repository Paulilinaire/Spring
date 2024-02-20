package org.example.exo3_blog.controller;

import jakarta.validation.Valid;
import org.example.exo3_blog.model.PostDto;
import org.example.exo3_blog.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/blog")
public class PostRestController {

    private final BaseService<PostDto> postService;

    public PostRestController(BaseService<PostDto> postService) {
        this.postService = postService;
    }

    @GetMapping("/posts") // http://localhost:8080/api/v1/blog/posts
    public List<PostDto> getAllPostDtos(){
        return postService.getAll();
    }

    @GetMapping("/post/{id}") // http://localhost:8080/api/v1/blog/post/x
    public PostDto getPostDtoById(@PathVariable("id") UUID id){
        System.out.println(id);
        System.out.println(postService.getById(id));
        return postService.getById(id);
    }

    @PostMapping("/add") // http://localhost:8080/api/v1/blog/add
    public ResponseEntity<String> createPostDto(@Valid @RequestBody PostDto post, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.create(post);
        return new ResponseEntity<>("PostDto created with id n° "+post.getId(), HttpStatus.CREATED);
    }

}
