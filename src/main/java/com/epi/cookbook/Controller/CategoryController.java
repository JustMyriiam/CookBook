package com.epi.cookbook.Controller;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Service.CategoryInterfaceImplementation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class CategoryController {

    CategoryInterfaceImplementation categoryInterfaceImplementation;

    @GetMapping("/categories/all")
    public String getAllCategory(Model model, @RequestParam(defaultValue = "0") int pageNumber,
                                 @RequestParam(defaultValue = "10") int size) {
        Page<Category> categoryPage = categoryInterfaceImplementation.getAllCategories(PageRequest.of(pageNumber, size));

        model.addAttribute("categories", categoryPage.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", new int[categoryPage.getTotalPages()]);
        return "ListCategories";
    }

    @GetMapping("/categories/delete/{id}")
    public String DeleteCategoryById2(@PathVariable Long id) {
        categoryInterfaceImplementation.DeleteCategory(id);
        return "redirect:/categories/all";
    }


    @PostMapping("/categories/save")
    public String AddCategory(Model model, @Valid Category category,BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/categories/add";
        }
        categoryInterfaceImplementation.SaveCategory(category);
        return "redirect:/categories/all";
    }

    @GetMapping("/categories/add")
    public String AddCategory(Model model) {
        model.addAttribute("categories", categoryInterfaceImplementation.GetAllCategory());
        model.addAttribute("category", new Category());
        return "AddCategory";
    }


    @GetMapping("/categories/update/{id}")
    public String updateCategoryById(Model model, @PathVariable Long id) {
        Category c = categoryInterfaceImplementation.GetCategoryById(id);
        model.addAttribute("categories", categoryInterfaceImplementation.GetAllCategory());
        model.addAttribute("category", c);
        return "UpdateCategory";
    }

}
