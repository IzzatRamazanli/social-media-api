package com.izzat.restapi.controller;

import com.izzat.restapi.enums.UserExceptionEnum;
import com.izzat.restapi.exception.UserNotFoundException;
import com.izzat.restapi.model.Post;
import com.izzat.restapi.model.User;
import com.izzat.restapi.service.PostService;
import com.izzat.restapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/v2")
@RequiredArgsConstructor
public class UserControllerV2 {
    private final UserService userService;
    private final PostService postService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public EntityModel<User> getUserById(@PathVariable Long id) {
        User user = getUser(id);
        EntityModel<User> userEntityModel = EntityModel.of(user);

        WebMvcLinkBuilder allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(this.getClass())
                .getAllUsers());
        userEntityModel.add(allUsersLink.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User saved = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/posts")
    public List<Post> getAllPostsByUser(@PathVariable Long id) {
        User userById = getUser(id);
        return userById.getPosts();
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> savePost(@PathVariable Long id, @Valid @RequestBody Post post) {
        User user = getUser(id);
        post.setUser(user);
        Post savedPost = postService.savePost(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getPostId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    private User getUser(Long id) {
        User userById = userService.getUserById(id);
        if (userById == null) throw new UserNotFoundException(UserExceptionEnum.USER_NOT_FOUND);
        return userById;
    }
}
