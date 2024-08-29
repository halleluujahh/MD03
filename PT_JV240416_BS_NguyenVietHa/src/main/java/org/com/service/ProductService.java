package org.com.service;

import org.com.dto.request.CategoryDTO;
import org.com.dto.request.ProductDTO;
import org.com.dto.response.ProductRes;
import org.com.entity.Product;

import java.util.List;

public interface ProductService {
    boolean save(ProductDTO productDTO);
    List<ProductRes> findAll(Integer pageNo, int pageSize);
    Product findById(int id);
    boolean remove(int id);
    boolean update(ProductDTO productDTO);
    List<ProductRes> findAllByName(String name);
}
