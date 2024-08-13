package org.com.session08.service;

import org.com.session08.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    boolean deleteBookById(int bookId);
    Book getBookByBookId(int bookId);
    boolean updateBook(Book b);
    boolean addBook(Book b);
    List<Book> searchByCriteria(String keyword, String criteria, float price);
}
