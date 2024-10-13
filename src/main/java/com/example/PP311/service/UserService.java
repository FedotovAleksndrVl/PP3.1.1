package com.example.PP311.service;

import com.example.PP311.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUserById(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();

    void updateUser(User user);

}