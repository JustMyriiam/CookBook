package com.epi.cookbook.Repository;

import com.epi.cookbook.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends JpaRepository<Recipe,Long> {


}
