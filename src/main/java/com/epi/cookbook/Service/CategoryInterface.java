package com.epi.cookbook.Service;

import com.epi.cookbook.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryInterface {

    public List<Category> GetAllCategory();
    Page<Category> getAllCategories(Pageable pageable);

    public Category GetCategoryById(Long id);
    public void DeleteCategory(Long id);
    public Category SaveCategory (Category category);
    public Category  UpdateCategory (Category category);
}
