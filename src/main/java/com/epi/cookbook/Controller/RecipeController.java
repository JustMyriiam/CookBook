package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Entity.Recipe;
import com.epi.cookbook.Service.RecipeInterface;
import com.epi.cookbook.Service.RecipeInterfaceImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class RecipeController {

    RecipeInterfaceImplementation recipeInterfaceImplementation;
    RecipeInterface recipeInterface;

    @GetMapping("/recipes/all")
    public String getAllRecipes(Model model){
        List<Recipe> recipeList = recipeInterfaceImplementation.getAllRecipes();
        model.addAttribute("recipes", recipeList);

        return "ListRecipes";
    }

    @GetMapping("/recipes/add")
    public String addRecipe(Model model){
        // Retrieve all recipes, ingredients, and categories
        List<Recipe> recipes = recipeInterfaceImplementation.getAllRecipes();
        List<Ingredient> ingredients = recipeInterfaceImplementation.getAllIngredients();
        List<Category> categories = recipeInterfaceImplementation.getAllCategories();

        // Add the retrieved data to the model
        model.addAttribute("recipes", recipes);
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("categories", categories);
        return "AddRecipe";
    }

    @PostMapping("/recipes/save")
    public String AddRecipe(Model model,Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/recipes/add";
        }
        recipeInterfaceImplementation.SaveRecipe(recipe);
        return "redirect:/recipes/all";
    }
    @GetMapping("/recipes/update/{id}")
    public String updateRecipeById(Model model, @PathVariable Long id){
        Recipe recipe = recipeInterface.GetRecipeById(id);
        model.addAttribute("recipes", recipeInterfaceImplementation.getAllRecipes());
        model.addAttribute("recipe", recipe);
        return "UpdateRecipe";
    }

    @GetMapping("/recipes/delete/{id}")
    public String deleteRecipeById2(@PathVariable Long id){
        recipeInterfaceImplementation.DeleteRecipe(id);
        return "redirect:/recipes/all";
    }
}
