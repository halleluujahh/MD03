package org.com.service.impl;

import org.com.dto.mapper.impl.MapperCategoryImpl;
import org.com.dto.request.CategoryDTO;
import org.com.entity.Category;
import org.com.repository.CategoryRepository;
import org.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MapperCategoryImpl mapperCategoryImpl;

    @Override
    public boolean save(CategoryDTO category) {
        if (categoryRepository.findByName(category.getName()) != null) {
            return false;
        }
        return categoryRepository.save(mapperCategoryImpl.mapperRequestToEntity(category));
    }

    @Override
    public List<CategoryDTO> findAll(Integer pageNo, int pageSize) {
        if(pageNo<=0){
            pageNo=1;
        }
        List<Category> listCategory = categoryRepository.findAll(pageNo, pageSize);
        List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
        for (int i = 0; i < listCategory.size(); i++) {
            listCategoryDTO.add(mapperCategoryImpl.mapperEntityToResponse(listCategory.get(i)));
        }
        return listCategoryDTO;
    }

    @Override
    public Category findById(int id) {
        if(categoryRepository.findById(id) != null) {
            return categoryRepository.findById(id);
        }
        return null;
    }

    @Override
    public boolean remove(int id) {
        if(categoryRepository.findById(id)==null) {
            return categoryRepository.remove(id);
        }
        return false;
    }

    @Override
    public boolean update(CategoryDTO category) {
        if (categoryRepository.findByName(category.getName()) != null) {
            return false;
        }
        return categoryRepository.update(mapperCategoryImpl.mapperRequestToEntity(category));
    }

    @Override
    public List<CategoryDTO> findByName(String name) {
        List<Category> listCategory = categoryRepository.findAllByName(name);
        List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
        for (int i = 0; i < listCategory.size(); i++) {
            listCategoryDTO.add(mapperCategoryImpl.mapperEntityToResponse(listCategory.get(i)));
        }
        return listCategoryDTO;
    }
}
