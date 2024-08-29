package org.com.session16.repository.impl;

import org.com.session16.entity.Book;
import org.com.session16.entity.BookType;
import org.com.session16.repository.BookTypeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookTypeRepositoryImpl implements BookTypeRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public boolean save(BookType bookType) {
        try {
            entityManager.persist(bookType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<BookType> findAll() {
        return entityManager.createQuery("from BookType ", BookType.class).getResultList();
    }

    @Override
    public BookType findById(int id) {
        return entityManager.find(BookType.class, id);
    }

    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        try {
            bookType = entityManager.createQuery("from BookType where typeName=:name", BookType.class).
                    setParameter("name", name).getSingleResult();
            return bookType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean remove(int id) {
        try {
            entityManager.remove(findById(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(BookType bookType) {
        try {
            entityManager.merge(bookType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
