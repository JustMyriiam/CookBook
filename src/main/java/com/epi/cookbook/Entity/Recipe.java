// Recipe.java
package com.epi.cookbook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Name is required")
    //@Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    //@Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    //@Size(max = 1000, message = "Instructions must be at most 1000 characters")
    private String instructions;

    //@Positive(message = "Preparation time must be a positive value")
    private int preparationTime; // Time of preparation in minutes

    private boolean ovenRequired; // Indicates if the recipe needs to be cooked in the oven

    //@Positive(message = "Servings must be a positive value")
    private int servings; // Number of persons the recipe serves


    private String imagePath;


    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients = new HashSet<>();

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", preparationTime=" + preparationTime +
                ", ovenRequired=" + ovenRequired +
                ", servings=" + servings +
                ", imagePath='" + imagePath + '\'' +
                ", category=" + category +
                ", ingredients=" + ingredients.toString()+
                '}';
    }

    public Recipe(String name, String description, String instructions, int preparationTime, boolean ovenRequired, int servings, String imagePath, Category category) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.ovenRequired = ovenRequired;
        this.servings = servings;
        this.imagePath = imagePath;
        this.category = category;
    }
}
