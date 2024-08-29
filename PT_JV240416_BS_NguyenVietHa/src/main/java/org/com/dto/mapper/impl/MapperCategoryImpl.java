package org.com.dto.mapper.impl;

import org.com.dto.mapper.Mapper;
import org.com.dto.request.CategoryDTO;
import org.com.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class MapperCategoryImpl implements Mapper<CategoryDTO, Category, CategoryDTO> {
    @Override
    public Category mapperRequestToEntity(CategoryDTO entity) {
        return Category.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.isStatus())
                .build();
    }

    @Override
    public CategoryDTO mapperEntityToResponse(Category entity) {
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.isStatus())
                .build();
    }
}
