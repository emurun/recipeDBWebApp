package com.example.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipeapp.model.Marketing;

public interface MarketingRepository extends JpaRepository<Marketing, Long> {
    // Custom query to find recipes by user
    Marketing findByEmail(String email);

    // List<Marketing> findByOptIn(Boolean optIn);

    void deleteByEmail(String email);

}
