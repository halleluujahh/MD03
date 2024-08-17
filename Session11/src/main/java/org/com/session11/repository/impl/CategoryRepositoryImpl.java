package org.com.session11.repository.impl;

import org.com.session11.model.Category;
import org.com.session11.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findById(Integer id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public boolean save(Category category) {
        try{
            entityManager.persist(category);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        try {
            entityManager.merge(category);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        try {
            entityManager.remove(findById(id));
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
