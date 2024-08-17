package org.com.session11.service;

import org.com.session11.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    boolean save(Category category);

    boolean update(Category category);

    boolean delete(Integer id);
}
