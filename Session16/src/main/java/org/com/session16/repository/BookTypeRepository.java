package org.com.session16.repository;

import org.com.session16.entity.Book;
import org.com.session16.entity.BookType;

import java.util.List;

public interface BookTypeRepository {
    boolean save(BookType bookType);
    List<BookType> findAll();
    BookType findById(int id);
    boolean remove(int id);
    boolean update(BookType bookType);
    BookType findByName(String name);
}
