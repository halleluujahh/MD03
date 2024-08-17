package org.com.session11.repository;

import org.com.session11.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Integer id);

    boolean save(Product category);

    boolean update(Product category);

    boolean delete(Integer id);
}
