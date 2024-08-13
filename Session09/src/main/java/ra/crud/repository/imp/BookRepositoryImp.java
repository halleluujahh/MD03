package ra.crud.repository.imp;

import org.springframework.stereotype.Repository;
import ra.crud.model.Book;
import ra.crud.repository.BookRepository;
import ra.crud.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBooks = null;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call find_all_book()}");
            ResultSet rs = callSt.executeQuery();
            listBooks = new ArrayList<Book>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setStatus(rs.getBoolean("book_status"));
                listBooks.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBooks;
    }

    @Override
    public Book findById(String bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call find_book_by_id(?)}");
            callSt.setString(1, bookId);
            ResultSet rs = callSt.executeQuery();
            book = new Book();
            if (rs.next()) {
                book.setBookId(rs.getString("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setStatus(rs.getBoolean("book_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean create(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call create_book(?,?,?,?)}");
            callSt.setString(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setFloat(3, book.getPrice());
            callSt.setBoolean(4, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?)}");
            callSt.setString(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setFloat(3, book.getPrice());
            callSt.setBoolean(4, book.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setString(1, bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
