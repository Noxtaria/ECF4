package com.example.ecf4_observatoire.domain.service;

import com.example.ecf4_observatoire.domain.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByUsername(String username);
}