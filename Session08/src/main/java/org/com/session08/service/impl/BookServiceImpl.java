package org.com.session08.service.impl;

import org.com.session08.entity.Book;
import org.com.session08.repository.BookRepository;
import org.com.session08.repository.impl.BookRepositoryImpl;
import org.com.session08.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getAllBook();
    }

    @Override
    public boolean deleteBookById(int bookId) {
        return bookRepository.deleteBookById(bookId);
    }

    @Override
    public Book getBookByBookId(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public boolean updateBook(Book b) {
        return bookRepository.updateBook(b);
    }

    @Override
    public boolean addBook(Book b) {
        return bookRepository.addBook(b);
    }

    @Override
    public List<Book> searchByCriteria(String keyword, String criteria, float price) {
        return bookRepository.getBooksByCriteriaSearch(keyword,criteria,price);
    }
}
