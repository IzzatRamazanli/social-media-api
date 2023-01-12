package com.izzat.restapi.service.impl;

import com.izzat.restapi.model.Post;
import com.izzat.restapi.repository.PostRepository;
import com.izzat.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
