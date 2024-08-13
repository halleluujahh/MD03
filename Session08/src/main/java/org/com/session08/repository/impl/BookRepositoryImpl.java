package org.com.session08.repository.impl;

import org.com.session08.entity.Book;
import org.com.session08.repository.BookRepository;
import org.com.session08.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> getAllBook() {
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        List<Book> books = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call getAllBook()}");
            rs = cstmt.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setContent(rs.getString("book_content"));
                book.setPublisher(rs.getString("book_publisher"));
                book.setStatus(rs.getBoolean("book_status"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return books;
    }

    @Override
    public boolean deleteBookById(int bookId) {
        Connection conn = null;
        CallableStatement ctsm = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            ctsm = conn.prepareCall("{call deleteBookById(?)}");
            ctsm.setInt(1, bookId);
            ctsm.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, ctsm);
        }
        return result;
    }

    @Override
    public Book getBookById(int bookId) {
        Connection conn = null;
        CallableStatement ctsm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.getConnection();
            ctsm = conn.prepareCall("{call getBookById(?)}");
            ctsm.setInt(1, bookId);
            rs = ctsm.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setContent(rs.getString("book_content"));
                book.setPublisher(rs.getString("book_publisher"));
                book.setStatus(rs.getBoolean("book_status"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, ctsm);
        }
        return null;
    }

    @Override
    public boolean updateBook(Book b) {
        Connection conn = null;
        CallableStatement ctsm = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            ctsm = conn.prepareCall("{call updateBookById(?,?,?,?,?,?,?,?)}");
            ctsm.setInt(1, b.getBookId());
            ctsm.setString(2, b.getBookName());
            ctsm.setFloat(3, b.getPrice());
            ctsm.setString(4, b.getTitle());
            ctsm.setString(5, b.getAuthor());
            ctsm.setString(6, b.getContent());
            ctsm.setString(7, b.getPublisher());
            ctsm.setBoolean(8, b.isStatus());
            ctsm.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, ctsm);
        }
        return result;
    }

    @Override
    public boolean addBook(Book b) {
        Connection conn = null;
        CallableStatement ctsm = null;
        boolean result = false;
        try {
            conn = ConnectionDB.getConnection();
            ctsm = conn.prepareCall("{call addBook(?,?,?,?,?,?,?)}");
            ctsm.setString(1, b.getBookName());
            ctsm.setFloat(2, b.getPrice());
            ctsm.setString(3, b.getTitle());
            ctsm.setString(4, b.getAuthor());
            ctsm.setString(5, b.getContent());
            ctsm.setString(6, b.getPublisher());
            ctsm.setBoolean(7, b.isStatus());
            ctsm.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, ctsm);
        }
        return result;
    }

    @Override
    public List<Book> getBooksByCriteriaSearch(String keyword, String criteria, float price) {
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        List<Book> books = null;
        try {
            conn = ConnectionDB.getConnection();
            cstmt = conn.prepareCall("{call getBookBySearchCriteria(?, ? ,?)}");
            cstmt.setString(1,  keyword);
            cstmt.setString(2, criteria);
            cstmt.setFloat(3, price);
            rs = cstmt.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("book_price"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setContent(rs.getString("book_content"));
                book.setPublisher(rs.getString("book_publisher"));
                book.setStatus(rs.getBoolean("book_status"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return books;
    }
}
