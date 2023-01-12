package com.izzat.restapi.service;

import com.izzat.restapi.model.Post;

public interface PostService {
    Post savePost(Post post);

    Post getPostById(Long userId, Long postId);
}
