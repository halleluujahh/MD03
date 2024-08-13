package org.com.session08.repository;

import org.com.session08.entity.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> getAllBook();

    public boolean deleteBookById(int bookId);

    public Book getBookById(int bookId);

    public boolean updateBook(Book b);

    public boolean addBook(Book b);

    public List<Book> getBooksByCriteriaSearch(String keyword, String criteria, float price);
}
