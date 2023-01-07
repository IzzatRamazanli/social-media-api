package com.izzat.restapi.controller;

import com.izzat.restapi.dao.UserDaoService;
import com.izzat.restapi.enums.UserExceptionEnum;
import com.izzat.restapi.exception.UserNotFoundException;
import com.izzat.restapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserDaoService userDaoService;

    @GetMapping
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        User user = userDaoService.findById(id);
        if (user != null) return user;
        else throw new UserNotFoundException(UserExceptionEnum.USER_NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (user.getName() != null) {
            User saved = userDaoService.saveUser(user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getUserId())
                    .toUri();
            return ResponseEntity.created(location).build();
        } else throw new RuntimeException(UserExceptionEnum.USER_CREDENTIALS_INCORRECT.getMessage());

    }
}
