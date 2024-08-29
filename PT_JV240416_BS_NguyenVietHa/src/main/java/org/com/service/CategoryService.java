package org.com.service;

import org.com.dto.request.CategoryDTO;
import org.com.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean save(CategoryDTO category);
    List<CategoryDTO> findAll(Integer pageNo, int pageSize);
    Category findById(int id);
    boolean remove(int id);
    boolean update(CategoryDTO category);
    List<CategoryDTO> findByName(String name);
}
