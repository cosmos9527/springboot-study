package com.samuel.service.Impl;

import com.samuel.dao.UserRepository;
import com.samuel.entity.User;
import com.samuel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
