package org.com.session11.service.impl;

import lombok.AllArgsConstructor;
import org.com.session11.model.Product;
import org.com.session11.repository.ProductRepository;
import org.com.session11.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        product.setView(0);
        product.setCreated(new Date());
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        Product p1 = productRepository.findById(product.getId());
        product.setCreated(p1.getCreated());
        product.setView(p1.getView());
        return productRepository.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public Product viewDetailsProduct(Integer id) {
        Product product = productRepository.findById(id);
        product.setView(product.getView() + 1);
        productRepository.update(product);
        return product;
    }
}
