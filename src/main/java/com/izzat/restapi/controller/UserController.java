package com.izzat.restapi.controller;

import com.izzat.restapi.dao.UserDaoService;
import com.izzat.restapi.enums.UserExceptionEnum;
import com.izzat.restapi.exception.UserNotFoundException;
import com.izzat.restapi.model.User;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDaoService userDaoService;

    @GetMapping
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("{id}")
    public EntityModel<User> getUserById(@PathVariable Long id) {
        User user = userDaoService.findById(id);
        EntityModel<User> userEntityModel = EntityModel.of(user);

        WebMvcLinkBuilder allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(this.getClass())
                .getAllUsers());
        userEntityModel.add(allUsersLink.withRel("all-users"));

        if (userEntityModel.getContent() != null) return userEntityModel;
        else throw new UserNotFoundException(UserExceptionEnum.USER_NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User saved = userDaoService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
        userDaoService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
