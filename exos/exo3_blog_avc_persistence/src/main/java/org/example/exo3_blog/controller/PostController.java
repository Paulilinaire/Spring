package org.example.exo3_blog.controller;

import jakarta.validation.Valid;
import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.entity.Post;
import org.example.exo3_blog.model.CommentDto;
import org.example.exo3_blog.model.PostDto;
import org.example.exo3_blog.service.BaseService;
import org.example.exo3_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Controller
public class PostController {

    private String location = "upload-dir";
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String homePage(@RequestParam(name = "search", required = false) String search, Model model) {
        if (search == null) {
            model.addAttribute("posts", postService.getAll());
        } else {
            model.addAttribute("posts", postService.search(search));
        }
        return "homepage";
    }

    @GetMapping("/form")
    public String formAddPost(Model model){
        model.addAttribute("post",new PostDto());
        return "post/form";
    }

    @PostMapping("/addpost")
    public String addPost(@Valid @ModelAttribute("post") PostDto post, BindingResult result){
        postService.create(post);
        return "post/form";
    }


    @GetMapping("/updatepost")
    public String formUpdatePost(@RequestParam("postId") UUID id,Model model){
        PostDto post = postService.getById(id);
        model.addAttribute("post",post);
        return "post/form";
    }



    @GetMapping("/post/{id}")
    public String showPost(@PathVariable UUID id, Model model) {
        PostDto post = postService.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("comment",  new Comment());
        return "post/post-content";
    }

    @PostMapping("/post/{id}/add-comment")
    public String addCommentToPost(@Valid @ModelAttribute CommentDto comment, UUID id, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("postId", id);
            model.addAttribute("comment", comment);
            return "post/post-content";
        } else {
            comment.setDate(LocalDate.now());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            comment.setTime(LocalTime.parse(LocalTime.now().format(formatter)));
            postService.addCommentToPost(id, comment);
            return "redirect:/post/" + id;
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("postId") UUID id) {
        postService.delete(id);
        return "redirect:";
    }


}
