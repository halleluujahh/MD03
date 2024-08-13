package ra.crud.repository;

import ra.crud.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(String bookId);
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(String bookId);
}
