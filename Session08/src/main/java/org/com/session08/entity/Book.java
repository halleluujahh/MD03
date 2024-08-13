package org.com.session08.entity;

public class Book {
    private int bookId;
    private String bookName;
    private float price;
    private String title;
    private String author;
    private String content;
    private String publisher;
    private boolean status;

    public Book() {
    }

    public Book(int bookId, String bookName, float price, String title, String author, String content, String publisher, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.title = title;
        this.author = author;
        this.content = content;
        this.publisher = publisher;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
