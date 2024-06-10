package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Ingredient;

import java.util.List;

public interface IngredientInterface {

    public List<Ingredient> GetAllIngredient();
    public Ingredient GetIngredientById(Long id);
    public void DeleteIngredient(Long id);
    public Ingredient SaveIngredient (Ingredient ingredient);
    public Ingredient  UpdateIngredient (Ingredient ingredient);
}
