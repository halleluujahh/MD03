package org.com.session16.repository.impl;

import org.com.session16.entity.Book;
import org.com.session16.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public boolean save(Book book) {
        try {
            entityManager.persist(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    public List<Book> findAll(int pageNumber, int pageSize) {
        return entityManager.createQuery("from Book", Book.class)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public Book findById(String id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public boolean remove(String id) {
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
    public boolean update(Book book) {
        try {
            entityManager.merge(book);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book findByName(String name) {
        try {
            return entityManager.createQuery("from Book where name = :name", Book.class)
                    .setParameter("name", name).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
