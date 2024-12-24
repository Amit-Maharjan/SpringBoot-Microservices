package com.microservices.userservice.services;

import com.microservices.userservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
}
