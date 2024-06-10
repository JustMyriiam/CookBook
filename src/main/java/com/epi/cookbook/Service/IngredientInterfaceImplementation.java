package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientInterfaceImplementation implements IngredientInterface{

@Autowired
    IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> GetAllIngredient() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient GetIngredientById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public void DeleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient SaveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient UpdateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
