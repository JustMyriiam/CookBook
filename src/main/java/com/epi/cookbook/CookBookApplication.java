package com.epi.cookbook;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Entity.Ingredient;
import com.epi.cookbook.Entity.Recipe;
import com.epi.cookbook.Repository.CategoryRepository;
import com.epi.cookbook.Repository.IngredientRepository;
import com.epi.cookbook.Repository.RecipeRepository;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

//@Slf4j
@SpringBootApplication
public class CookBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookBookApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        return args -> {
            // Save categories
           Category c1 = new Category("Italian Cuisine", "Taste the Mediterranean", "Italian cuisine is known for its diversity and regional specialties. From pasta dishes like spaghetti and lasagna to pizza topped with fresh ingredients, Italian cuisine emphasizes simplicity and quality ingredients.");
            Category c2 = new Category("Mexican Cuisine", "Spice up your life", "Mexican cuisine is vibrant and flavorful, featuring dishes such as tacos, burritos, and enchiladas. With a focus on ingredients like chili peppers, beans, and corn, Mexican food offers a perfect balance of heat, texture, and taste.");
            Category c3 = new Category("Japanese Cuisine", "Taste the art of sushi", "Japanese cuisine is celebrated for its freshness, simplicity, and presentation. From sushi and sashimi to ramen and tempura, Japanese food showcases a delicate balance of flavors and textures, often highlighting seasonal ingredients.");
            categoryRepository.saveAll(List.of(c1, c2, c3));

            // Save ingredients
            Ingredient i1 = new Ingredient("Salt", "Seasoning", "salt.jpg");
            Ingredient i2 = new Ingredient("Sugar", "Sweetener", "sugar.jpg");
            Ingredient i3 = new Ingredient("Flour", "Baking Ingredient", "flour.jpg");
            ingredientRepository.saveAll(List.of(i1, i2, i3));

            // Create recipes
            Recipe r1 = new Recipe("Pasta Carbonara", "Classic Italian pasta dish", "Cook pasta according to package instructions. Meanwhile, fry bacon until crisp. In a separate bowl, mix eggs, Parmesan cheese, and black pepper. Drain pasta, then mix with bacon and egg mixture. Serve hot.", 20, false, 4, "carbonara.jpg", c1);
            Recipe r2 = new Recipe("Tacos al Pastor", "Traditional Mexican street food", "Marinate pork in achiote paste, pineapple juice, and spices. Grill pork until cooked. Serve in tortillas with pineapple, cilantro, and onion.", 30, true, 4, "tacos.jpg", c2);

            // Save recipes
            recipeRepository.saveAll(List.of(r1, r2));

            // Associate ingredients with recipes
            r1.getIngredients().addAll(Set.of(i1, i2));
            r2.getIngredients().addAll(Set.of(i1, i2));
            recipeRepository.saveAll(List.of(r1, r2));

            // Print out all recipes
            List<Recipe> recipes = recipeRepository.findAll();
            recipes.forEach(recipe -> System.out.println(recipe));
            };


        }
    }

