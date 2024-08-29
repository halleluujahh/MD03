package org.com.repository;

import org.com.dto.request.CategoryDTO;
import org.com.entity.Category;
import org.com.entity.Product;

import java.util.List;

public interface ProductRepository {
    boolean save(Product product);
    List<Product> findAll(Integer pageNo, int pageSize);
    Product findById(int id);
    boolean remove(int id);
    boolean update(Product category);
    Product findByName(String name);
    List<Product> findAllByName(String name);
}
