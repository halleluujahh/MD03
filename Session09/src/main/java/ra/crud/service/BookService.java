package ra.crud.service;

import ra.crud.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(String bookId);

    boolean create(Book book);

    boolean update(Book book);

    boolean delete(String bookId);
}
