package com.example.recipeapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.recipeapp.model.Marketing;
import com.example.recipeapp.repository.MarketingRepository;

@Service
public class MarketingService {
    private final MarketingRepository marketingRepository;

    @Autowired
    public MarketingService(MarketingRepository marketingRepository) {
        this.marketingRepository = marketingRepository;
    }

    public Marketing saveMarketing(Marketing marketing) {
        return marketingRepository.save(marketing);
    }

    public List<Marketing> getAllMarketing() {
        return marketingRepository.findAll();
    }

    public Marketing findOptInByEmail(String email) {
        return marketingRepository.findByEmail(email);
    }

    public void deleteByEmail(String email) {
        marketingRepository.deleteByEmail(email);
    }

}
