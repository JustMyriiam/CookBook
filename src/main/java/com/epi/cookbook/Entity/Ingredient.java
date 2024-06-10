// Ingredient.java
package com.epi.cookbook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Name is required")
    //@Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    //@Size(max = 200, message = "Type must be at most 200 characters")
    private String type;

    private String imagePath;


    public Ingredient(String name, String type, String imagePath) {
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
    }


}
