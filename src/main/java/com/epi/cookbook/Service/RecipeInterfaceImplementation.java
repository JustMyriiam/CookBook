package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Entity.Recipe;
import com.epi.cookbook.Repository.CategoryRepository;
import com.epi.cookbook.Repository.IngredientRepository;
import com.epi.cookbook.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeInterfaceImplementation implements RecipeInterface{

    RecipeRepository recipeRepository ;

    CategoryRepository categoryRepository;
    IngredientRepository ingredientRepository;

    @Autowired
    public RecipeInterfaceImplementation(RecipeRepository recipeRepository,
                                         CategoryRepository categoryRepository,
                                         IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
    }



    @Override
    public Recipe GetRecipeById(Long id) {
        return recipeRepository.findById(id).get();
    }

    @Override
    public void DeleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe SaveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    @Override
    public Recipe UpdateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }



    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();}

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
