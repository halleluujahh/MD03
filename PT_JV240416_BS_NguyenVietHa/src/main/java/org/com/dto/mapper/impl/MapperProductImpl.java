package org.com.dto.mapper.impl;

import com.google.api.client.util.DateTime;
import org.com.dto.mapper.Mapper;
import org.com.dto.request.ProductDTO;
import org.com.dto.response.ProductRes;
import org.com.entity.Category;
import org.com.entity.Product;
import org.com.service.CategoryService;
import org.com.service.ProductService;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MapperProductImpl implements Mapper<ProductDTO,Product,ProductRes> {
    @Autowired
    private  CategoryService categoryService;
    @Autowired
    private  ProductService productService;

    @Autowired
    public MapperProductImpl(@Lazy CategoryService categoryService, @Lazy ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public Product mapperRequestToEntity(ProductDTO entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .status(entity.isStatus())
                .image(null)
                .createdAt(new Date())
                .category(categoryService.findById(entity.getCategoryId()))
                .build();
    }

    @Override
    public ProductRes mapperEntityToResponse(Product entity) {
        return ProductRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .status(entity.isStatus())
                .image(entity.getImage())
                .createdAt(entity.getCreatedAt())
                .category(categoryService.findById(entity.getCategory().getId())).build();
    }


}
