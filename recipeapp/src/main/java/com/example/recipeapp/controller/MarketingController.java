package com.example.recipeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeapp.model.Marketing;
import com.example.recipeapp.model.StringObject;
import com.example.recipeapp.service.MarketingService;

@RestController
@RequestMapping("/api/marketing")
public class MarketingController {
    private final MarketingService marketingService;

    @Autowired
    public MarketingController(MarketingService marketingService) {
        this.marketingService = marketingService;
    }

    @GetMapping("/getAllMarketing")
    @ResponseBody
    public List<Marketing> getAllMarketing() {
        return marketingService.getAllMarketing();
    }

    @GetMapping(path = "/getMarketingByEmail", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Marketing> getMarketingByEmail(@RequestBody StringObject email) {
        return new ResponseEntity<>(marketingService.findOptInByEmail(email.getString()), HttpStatus.CREATED);
    }

    // Can be used to add or edit an email's marketing preferences
    @PostMapping(path = "/createMarketing", consumes = {
            "application/json" })
    @ResponseBody
    public ResponseEntity<Marketing> createMarketing(@RequestBody Marketing marketing) {
        Marketing savedMarketing = marketingService.saveMarketing(marketing);
        return new ResponseEntity<>(savedMarketing, HttpStatus.CREATED);
    }

    @PostMapping(path = "/deleteMarketing", consumes = {
            "application/json" })
    @ResponseBody
    public void deleteMarketing(@RequestBody StringObject email) {
        marketingService.deleteByEmail(email.getString());
        System.out.println("Marketing record deleted!");
    }

}
