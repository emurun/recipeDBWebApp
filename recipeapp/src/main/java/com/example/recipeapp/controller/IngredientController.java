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

import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.LongObject;
import com.example.recipeapp.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/getAllIngredients")
    @ResponseBody
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return new ResponseEntity<>(ingredientService.getAllIngredients(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getIngredientById", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> getIngredientsById(@RequestBody LongObject id) {
        return new ResponseEntity<>(ingredientService.getIngredientById(id.getLong()).getIngredientName(),
                HttpStatus.CREATED);
    }

    @PostMapping(value = "/createIngredient", consumes = {
            "application/json" })
    @ResponseBody
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
        return new ResponseEntity<>(savedIngredient, HttpStatus.CREATED);
    }
}
