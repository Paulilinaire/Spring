package org.example.exo3_blog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exo3_blog.model.Comment;
import org.example.exo3_blog.model.Post;
import org.example.exo3_blog.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final BaseService<Post> postService;

    @GetMapping String homePage(@RequestParam(name = "search",required = false) String search, Model model){
        if(search == null){
            model.addAttribute("posts", postService.getAll());
        } else {
            model.addAttribute("posts", postService.search(search));
        }
        return "homepage";
    }

    @GetMapping("/post/{id}")  // http://localhost:8080/post/x
    public String showPost(@PathVariable UUID id, Model model){
        model.addAttribute("post",postService.getById(id));
        return "post/post-content";
    }


    @GetMapping("/post/{id}/add-comment")
    public String showAddCommentForm(@PathVariable UUID id, Model model) {
        model.addAttribute("postId", id);
        model.addAttribute("comment", new Comment());
        return "comment/add-comment-form";
    }


    @PostMapping("/post/{id}/add-comment")
    public String addCommentToPost(@PathVariable UUID id, @ModelAttribute @Valid Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("postId", id);
            return "comment/add-comment-form";
        }else {
            postService.addCommentToPost(id, comment);
            return "redirect:/post/post-content";
        }
    }


}
