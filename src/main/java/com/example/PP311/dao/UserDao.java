package com.example.PP311.dao;

import com.example.PP311.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();

    void updateUser(User user);

}
