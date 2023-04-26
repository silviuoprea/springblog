package com.ratonu.diary.controllers;

import com.ratonu.diary.entities.Post;
import com.ratonu.diary.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final PostService postService;
    public BlogController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping(value = "/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value = "/post")
    public void publishPost(@RequestBody Post post)
    {
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        postService.insert(post);
    }
}
