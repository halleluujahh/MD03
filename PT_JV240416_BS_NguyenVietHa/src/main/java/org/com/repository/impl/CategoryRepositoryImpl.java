package org.com.repository.impl;

import org.com.entity.Category;
import org.com.repository.CategoryRepository;
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
    @Transactional
    public boolean save(Category category) {
        try {
            entityManager.persist(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> findAll(int pageNo, int pageSize) {
        return entityManager.createQuery("from Category", Category.class)
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public boolean remove(int id) {
        try{
            entityManager.remove(findById(id));
            return true;
        }catch (Exception e){
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findByName(String name) {
        try {
            return entityManager.createQuery("from Category where name = :name", Category.class)
                    .setParameter("name", name).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAllByName(String name) {
        try {
            return entityManager.createQuery("from Category where name like :name", Category.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
