package com.izzat.restapi.service.impl;

import com.izzat.restapi.enums.PostExceptionEnum;
import com.izzat.restapi.enums.UserExceptionEnum;
import com.izzat.restapi.exception.PostNotFoundException;
import com.izzat.restapi.exception.UserNotFoundException;
import com.izzat.restapi.model.Post;
import com.izzat.restapi.model.User;
import com.izzat.restapi.repository.PostRepository;
import com.izzat.restapi.service.PostService;
import com.izzat.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long userId, Long postId) {
        User userById = userService.getUserById(userId);
        if (userById == null) throw new UserNotFoundException(UserExceptionEnum.USER_NOT_FOUND);
        List<Post> posts = userById.getPosts();
        Optional<Post> find = getPost(postId, posts);
        if (find.isEmpty()) throw new PostNotFoundException(PostExceptionEnum.POST_NOT_FOUND);
        return find.get();

    }

    private Optional<Post> getPost(Long postId, List<Post> posts) {
        return posts.stream().
                filter(search(postId))
                .findFirst();
    }

    private Predicate<Post> search(Long id) {
        return post -> post.getPostId().equals(id);
    }
}
