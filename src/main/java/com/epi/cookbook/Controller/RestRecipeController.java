package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Recipe;
import com.epi.cookbook.Service.RecipeInterfaceImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestRecipeController {
    RecipeInterfaceImplementation recipeInterfaceImplementation;

    //********http://localhost:8080/api/all

    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeInterfaceImplementation.getAllRecipes();
    }

    //********http://localhost:8080/api/Recipe/10

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeInterfaceImplementation.GetRecipeById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeInterfaceImplementation.DeleteRecipe(id);

    }

    @PostMapping("/recipes")
    public Recipe save(@RequestBody Recipe recipe) {

        return recipeInterfaceImplementation.SaveRecipe(recipe);
    }

    @PutMapping("/recipes")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {

        return recipeInterfaceImplementation.UpdateRecipe(recipe);
    }
}
