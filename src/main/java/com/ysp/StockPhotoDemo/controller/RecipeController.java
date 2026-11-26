package com.ysp.StockPhotoDemo.controller;

import com.ysp.StockPhotoDemo.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe-create")
    public String createRecipe(@RequestParam(name = "ingredients") String ingredients,
                               @RequestParam(name = "cuisine", defaultValue = "any") String cuisine,
                               @RequestParam(name = "dietaryRestrictions", defaultValue = "none") String dietaryRestrictions
                               ){
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }
}
