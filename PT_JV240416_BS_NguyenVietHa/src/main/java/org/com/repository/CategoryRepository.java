package org.com.repository;

import org.com.entity.Category;

import java.util.List;

public interface CategoryRepository {
    boolean save(Category category);
    List<Category> findAll(int pageNo, int pageSize);
    Category findById(int id);
    boolean remove(int id);
    boolean update(Category category);
    Category findByName(String name);
    List<Category> findAllByName(String name);
}
