package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Service.IngredientInterfaceImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestIngredientController {
    IngredientInterfaceImplementation ingredientInterfaceImplementation;

    //********http://localhost:8080/api/all

    @GetMapping("/all")
    public List<Ingredient> getAllIngredient() {
        return ingredientInterfaceImplementation.GetAllIngredient();
    }

    //********http://localhost:8080/api/Ingredient/10

    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredient(@PathVariable Long id) {
        return ingredientInterfaceImplementation.GetIngredientById(id);

    }

    @DeleteMapping("/{id}")
    public void deletefilm(@PathVariable("id") Long id) {
        ingredientInterfaceImplementation.DeleteIngredient(id);

    }

    @PostMapping("/ingredients")
    public Ingredient save(@RequestBody Ingredient ingredient) {

        return ingredientInterfaceImplementation.SaveIngredient(ingredient);
    }

    @PutMapping("/ingredients")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {

        return ingredientInterfaceImplementation.UpdateIngredient(ingredient);
    }
}
