package com.example.recipeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipeapp.model.User;
import com.example.recipeapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        // Include password encoding and other business logic here
        return userRepository.save(user);
    }

    // Other business logic methods...
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);
        if (user == null)
            user = userRepository.findByUserName(email);

        if (user != null && password.equals(userRepository.findPasswordByEmail(email).getPassword()))
            return user;
        else
            return null;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String getUserNameByUserId(Long userId) {
        return userRepository.findByUserId(userId).getUserName();
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
