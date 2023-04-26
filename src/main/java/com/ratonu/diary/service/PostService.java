package com.ratonu.diary.service;

import com.ratonu.diary.entities.Post;
import com.ratonu.diary.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }
    public List<Post> getAllPosts()
    {
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
}
