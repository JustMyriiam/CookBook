package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Entity.Recipe;

import java.util.List;

public interface RecipeInterface {

    public Recipe GetRecipeById(Long id);
    public void DeleteRecipe(Long id);
    public Recipe SaveRecipe (Recipe recipe);
    public Recipe  UpdateRecipe (Recipe recipe);

    public List<Ingredient> getAllIngredients();

    public List<Category> getAllCategories();

    public List<Recipe> getAllRecipes();
}
