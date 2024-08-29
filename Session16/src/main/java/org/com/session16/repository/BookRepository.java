package org.com.session16.repository;

import org.com.session16.entity.Book;

import java.util.List;

public interface BookRepository {
    boolean save(Book book);
    List<Book> findAll();
    Book findById(String id);
    boolean remove(String id);
    boolean update(Book book);
    Book findByName(String name);
}
