// Category.java
package com.epi.cookbook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 200, message = "Slogan must be at most 200 characters")
    private String slogan;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Category(String name, String slogan, String description) {
        this.name = name;
        this.slogan = slogan;
        this.description = description;
    }
}
