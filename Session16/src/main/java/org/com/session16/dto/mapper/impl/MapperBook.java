package org.com.session16.dto.mapper.impl;

import org.com.session16.dto.mapper.Mapper;
import org.com.session16.dto.request.BookDTO;
import org.com.session16.entity.Book;
import org.com.session16.service.BookService;
import org.com.session16.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MapperBook implements Mapper<BookDTO, Book, BookDTO> {
    private final BookTypeService bookTypeService;
    private final BookService bookService;

    @Autowired
    public MapperBook(@Lazy BookTypeService bookTypeService, @Lazy BookService bookService) {
        this.bookTypeService = bookTypeService;
        this.bookService = bookService;
    }

    @Override
    public Book mapperRequestToEntity(BookDTO entity) {
        return Book.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .content(entity.getContent())
                .name(entity.getName())
                .price(entity.getPrice())
                .status(entity.isStatus())
                .create(bookService.findById(entity.getId()).getCreate())
                .booktype(bookTypeService.findById(entity.getBookTypeId()))
                .build();
    }

    @Override
    public BookDTO mapperEntityToResponse(Book entity) {
        return BookDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .status(entity.isStatus())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .bookTypeId(entity.getBooktype().getId())
                .build();
    }


}
