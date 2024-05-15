package com.example.recipeapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.model.RecipeInfo;
import com.example.recipeapp.model.RecipesIngredient;
import com.example.recipeapp.model.UsersRecipe;
import com.example.recipeapp.model.Ingredient;
import com.example.recipeapp.model.LongObject;
import com.example.recipeapp.service.IngredientService;
import com.example.recipeapp.service.RecipeService;
import com.example.recipeapp.service.RecipesIngredientService;
import com.example.recipeapp.service.UserService;
import com.example.recipeapp.service.UsersRecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final UserService userService;
    private final UsersRecipeService usersRecipeService;
    private final IngredientService ingredientService;
    private final RecipesIngredientService recipesIngredientService;

    @Autowired
    public RecipeController(RecipeService recipeService, UserService userService,
            RecipesIngredientService recipesIngredientService, IngredientService ingredientService,
            UsersRecipeService usersRecipeService) {
        this.recipeService = recipeService;
        this.userService = userService;
        this.recipesIngredientService = recipesIngredientService;
        this.usersRecipeService = usersRecipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/getAllRecipes")
    @ResponseBody
    public List<RecipeInfo> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        List<RecipeInfo> recipeInfo = new ArrayList<>();

        for (Recipe r : recipes) {
            Long recipeId = r.getId();

            recipeInfo.add(getRecipeInfo(recipeId));
        }

        return recipeInfo;
    }

    @PostMapping(path = "/getRecipeById", consumes = "application/json")
    public ResponseEntity<RecipeInfo> getRecipeById(@RequestBody LongObject id) {
        Long recipeId = id.getLong();

        return new ResponseEntity<>(getRecipeInfo(recipeId), HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/createRecipe", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeInfo recipeInfo) {
        String name = recipeInfo.getName();
        String instructions = recipeInfo.getInstructions();
        String description = recipeInfo.getDescription();

        System.out.println(name);
        System.out.println(description);
        System.out.println(instructions);
        Recipe recipe = new Recipe(description, instructions, name);
        recipeService.saveRecipe(recipe);
        Long recipeID = recipe.getId();

        List<String> ingredients = recipeInfo.getIngredients();
        Long ingredientId;
        for (String ingredientName : ingredients) {
            System.out.println(ingredientName);
            Ingredient ingredient = ingredientService.getIngredientByName(ingredientName);
            ingredientId = ingredient.getIngredientId();
            System.out.println(ingredientId);

            RecipesIngredient recipesIngredient = new RecipesIngredient(recipe, ingredient);
            System.out.println(recipesIngredient.getIngredient().getIngredientName());
            recipesIngredientService.saveRecipesIngredient(recipesIngredient);
        }

        Long userId = recipeInfo.getUserId();
        System.out.println("user: " + userId);
        String userName = userService.findByUserId(userId).getUserName();
        System.out.println(userName);
        usersRecipeService.saveUsersRecipe(new UsersRecipe(recipeID, userId));

        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    public RecipeInfo getRecipeInfo(Long recipeId) {

        Long userId = usersRecipeService.getUserByRecipe(recipeId);
        List<Long> ingredientIds = recipesIngredientService.getRecipesIngredientsByRecipeId(recipeId);

        String name = recipeService.getNameByRecipeId(recipeId);
        String description = recipeService.getDescriptionByRecipeId(recipeId);
        String instructions = recipeService.getInstructionsByRecipeId(recipeId);
        String userName = userService.getUserNameByUserId(userId);
        List<String> ingredients = new ArrayList<String>();

        for (Long l : ingredientIds) {
            String ingredient = ingredientService.getIngredientNameById(l);
            ingredients.add(ingredient);
        }

        return new RecipeInfo(recipeId, name, userName, description, instructions, ingredients);
    }

}
