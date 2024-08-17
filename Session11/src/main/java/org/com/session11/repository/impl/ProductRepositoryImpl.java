package org.com.session11.repository.impl;

import org.com.session11.model.Product;
import org.com.session11.repository.ProductRepository;
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
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        try{
            entityManager.persist(product);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
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
