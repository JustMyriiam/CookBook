package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Category;
import com.epi.cookbook.Repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryInterfaceImplementation implements CategoryInterface{
@Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> GetAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    @Override
    public Category GetCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void DeleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category SaveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category UpdateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
