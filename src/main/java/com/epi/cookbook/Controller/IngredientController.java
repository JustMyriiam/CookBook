package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Service.IngredientInterface;
import com.epi.cookbook.Service.IngredientInterfaceImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class IngredientController {

    IngredientInterfaceImplementation ingredientInterfaceImplementation;
    IngredientInterface ingredientInterface;

    @GetMapping("/ingredients/all")
    public String getAllIngredients(Model model) {
        List<Ingredient> ingredientList = ingredientInterfaceImplementation.GetAllIngredient();
        model.addAttribute("ingredients", ingredientList);
        return "ListIngredients";
    }

    @GetMapping("/ingredients/delete/{id}")
    public String deleteIngredientById2(@PathVariable Long id) {
        ingredientInterfaceImplementation.DeleteIngredient(id);
        return "redirect:/ingredients/all";
    }

    @GetMapping("/ingredients/add")
    public String addIngredient(Model model) {
        model.addAttribute("ingredients", ingredientInterfaceImplementation.GetAllIngredient());
        model.addAttribute("ingredient", new Ingredient());
        return "AddIngredient";
    }

    @PostMapping("/ingredients/save")
    public String AddIngredient(Model model,Ingredient ingredient, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/ingredients/add";
        }
        ingredientInterfaceImplementation.SaveIngredient(ingredient);
        return "redirect:/ingredients/all";
    }

    /*@PostMapping("/ingredients/update")
    public String updateIngredient(Model model, @ModelAttribute Ingredient ingredient) {
        ingredientInterfaceImplementation.SaveIngredient(ingredient);
        return "redirect:/ingredients/all";
    }*/

    @GetMapping("/ingredients/update/{id}")
    public String updateIngredientById(Model model, @PathVariable Long id) {
        Ingredient ingredient = ingredientInterface.GetIngredientById(id);
        model.addAttribute("ingredients", ingredientInterfaceImplementation.GetAllIngredient());
        model.addAttribute("ingredient", ingredient);
        return "UpdateIngredient";
    }
}
