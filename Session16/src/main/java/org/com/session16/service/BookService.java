package org.com.session16.service;

import org.com.session16.dto.request.BookDTO;
import org.com.session16.entity.Book;

import java.util.List;

public interface BookService {
    boolean save(BookDTO bookDto);
    List<Book> findAll();
    Book findById(String id);
    boolean remove(String id);
    boolean update(BookDTO bookDto, String bookNameOld);
}
