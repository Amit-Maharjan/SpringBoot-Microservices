package com.microservices.userservice.services.impl;

import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exceptions.ResourceNotFoundException;
import com.microservices.userservice.repositories.UserRepository;
import com.microservices.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User with id " + userId + " not found on the server !!"
                                )
                        );

        // Microservice calling microservice using RestTemplate
        ArrayList<Rating> ratingList = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
        logger.info("{}", ratingList);
        user.setRatings(ratingList);

        return user;
    }
}
