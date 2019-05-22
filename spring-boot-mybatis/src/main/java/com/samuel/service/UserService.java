package com.samuel.service;

import com.samuel.model.User;

import java.util.List;

public interface UserService {

    int save(User record);

    int update(User record);

    int delete(Long id);

    User find(Long id);

    List<User> findAll();
}
