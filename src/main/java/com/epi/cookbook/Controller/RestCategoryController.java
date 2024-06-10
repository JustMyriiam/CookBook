package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Service.CategoryInterfaceImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestCategoryController {

    CategoryInterfaceImplementation categoryInterfaceImplementation;

    //********http://localhost:8080/api/all

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryInterfaceImplementation.GetAllCategory();
    }

    //********http://localhost:8080/api/Category/10

    @GetMapping("/Category/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryInterfaceImplementation.GetCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryInterfaceImplementation.DeleteCategory(id);

    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category) {

        return categoryInterfaceImplementation.SaveCategory(category);
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {

        return categoryInterfaceImplementation.UpdateCategory(category);
    }
}
