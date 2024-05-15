package com.example.recipeapp.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(Long userId);

    public User findByEmail(String email);

    @Query("SELECT u.password FROM users u WHERE u.email = ?1")
    public User findPasswordByEmail(String email);

    public User findByUserName(String userName);
}
