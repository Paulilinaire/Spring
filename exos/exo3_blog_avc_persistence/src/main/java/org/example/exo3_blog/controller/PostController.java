package org.example.exo3_blog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exo3_blog.entity.Comment;
import org.example.exo3_blog.entity.Post;
import org.example.exo3_blog.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final BaseService<Post> postService;

    @GetMapping("/")
    public String homePage(@RequestParam(name = "search", required = false) String search, Model model) {
        if (search == null) {
            model.addAttribute("posts", postService.getAll());
        } else {
            System.out.println(search);
            model.addAttribute("posts", postService.search(search));
        }
        return "homepage";
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable UUID id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("comment",  new Comment());
        return "post/post-content";
    }

    @PostMapping("/post/{id}/add-comment")
    public String addCommentToPost(@Valid @ModelAttribute Comment comment, UUID id, BindingResult result, Model model) {
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
}
