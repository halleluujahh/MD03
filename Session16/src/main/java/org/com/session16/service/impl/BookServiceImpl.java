package org.com.session16.service.impl;

import lombok.AllArgsConstructor;
import org.com.session16.dto.mapper.impl.MapperBook;
import org.com.session16.dto.request.BookDTO;
import org.com.session16.entity.Book;
import org.com.session16.repository.BookRepository;
import org.com.session16.repository.BookTypeRepository;
import org.com.session16.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookTypeRepository bookTypeRepository;
    private MapperBook mapperBook;
    @Autowired
    public void setMapperBook(MapperBook mapperBook) {
        this.mapperBook = mapperBook;
    }
    @Override
    public boolean save(BookDTO bookDto) {
        if(bookRepository.findById(bookDto.getId()) != null){
            return false;
        }
        Book book = Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .price(bookDto.getPrice())
                .author(bookDto.getAuthor())
                .create(new Date())
                .booktype(bookTypeRepository.findById(bookDto.getBookTypeId()))
                .status(bookDto.isStatus())
                .content(bookDto.getContent())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean remove(String id) {
        return bookRepository.remove(id);
    }

    @Override
    public boolean update(BookDTO bookDto, String bookNameOld) {
        if(!bookDto.getName().equals(bookNameOld)){
            if(bookRepository.findByName(bookDto.getName())!=null){
                return false;
            }
        }
        return bookRepository.update(mapperBook.mapperRequestToEntity(bookDto));
    }
}
