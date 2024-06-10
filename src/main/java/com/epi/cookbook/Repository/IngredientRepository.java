package com.epi.cookbook.Repository;

import com.epi.cookbook.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IngredientRepository extends JpaRepository <Ingredient,Long> {
}
