package org.com.session11.service;

import org.com.session11.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    boolean save(Product category);

    boolean update(Product category);

    boolean delete(Integer id);

    Product viewDetailsProduct (Integer id);
}
