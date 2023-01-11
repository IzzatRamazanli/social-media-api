package com.izzat.restapi.service;

import com.izzat.restapi.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUserById(Long id);


}
