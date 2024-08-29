package org.com.repository.impl;

import org.com.entity.Category;
import org.com.entity.Product;
import org.com.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public boolean save(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAll(Integer pageNo, int pageSize) {
        return entityManager.createQuery("from Product", Product.class)
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
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
    public boolean update(Product category) {
        try {
            entityManager.merge(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Product findByName(String name) {
        try {
            return entityManager.createQuery("from Product where name = :name", Product.class)
                    .setParameter("name", name).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAllByName(String name) {
        try {
            return entityManager.createQuery("from Product where name like  :name", Product.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
