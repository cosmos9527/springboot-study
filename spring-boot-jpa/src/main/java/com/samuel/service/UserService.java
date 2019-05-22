package com.samuel.service;

import com.samuel.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long userId);

    void saveUser(User user);

    void updateUser(User user);

    void removeUser(Long userId);

    List<User> getUserList();
}
