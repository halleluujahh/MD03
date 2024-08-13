package org.com.session08.controller;


import org.com.session08.entity.Book;
import org.com.session08.service.BookService;
import org.com.session08.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        List<Book> listBooks = null;
        switch (action) {
            case "search":
                String keyword = request.getParameter("search");
                String criteria = request.getParameter("searchCriteria");
                String priceRangeStr = request.getParameter("price");
                float priceRange = 0;
                if(!priceRangeStr.isEmpty()){
                    priceRange = Float.parseFloat(request.getParameter("price"));
                }
                List<Book> listSearch = bookService.searchByCriteria(keyword,criteria, priceRange);
                request.setAttribute("books", listSearch);
                request.getRequestDispatcher("booklist.jsp").forward(request, response);
                break;
            case "delete":
                int bookId = Integer.parseInt(request.getParameter("bookId"));
                if(bookService.deleteBookById(bookId)){
                    request.setAttribute("msg","Delete success with Book Id:" + bookId);
                }else{
                    request.setAttribute("msg","Delete fail with Book Id:" + bookId);
                }
                listBooks = bookService.getBooks();
                request.setAttribute("books", listBooks);
                request.getRequestDispatcher("booklist.jsp").forward(request, response);
                break;
            case "update":
                bookId = Integer.parseInt(request.getParameter("bookId"));
                Book b = bookService.getBookByBookId(bookId);
                request.setAttribute("book", b);
                request.getRequestDispatcher("book-update.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("book-add.jsp").forward(request,response);
                break;
            default:
                listBooks = bookService.getBooks();
                request.setAttribute("books", listBooks);
                request.getRequestDispatcher("booklist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        List<Book> listBooks = null;
        switch (action){
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                float price = Float.parseFloat(request.getParameter("price"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String content = request.getParameter("content");
                String publisher = request.getParameter("publisher");
                String status = request.getParameter("status");
                Book b = new Book(id, name, price, title, author, content, publisher, Boolean.parseBoolean(status));
                if(bookService.updateBook(b)){
                    request.setAttribute("msg","Update success with Book Id" + id );
                }else {
                    request.setAttribute("msg","Update fail with Book Id" + id );
                }
                listBooks = bookService.getBooks();
                request.setAttribute("books", listBooks);
                request.getRequestDispatcher("booklist.jsp").forward(request, response);
                break;
            case "add":
                name = request.getParameter("name");
                price = Float.parseFloat(request.getParameter("price"));
                title = request.getParameter("title");
                author = request.getParameter("author");
                content = request.getParameter("content");
                publisher = request.getParameter("publisher");
                status = request.getParameter("status");
                Book b1 = new Book(0,name, price, title, author, content, publisher, Boolean.parseBoolean(status));
                if(bookService.addBook(b1)){
                    request.setAttribute("msg","Add success");
                }else {
                    request.setAttribute("msg","Add fail");
                }
                listBooks = bookService.getBooks();
                request.setAttribute("books", listBooks);
                request.getRequestDispatcher("booklist.jsp").forward(request, response);
                break;
        }
    }
}