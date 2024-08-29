package org.com.session16.service;

import org.com.session16.dto.request.BookTypeDTO;
import org.com.session16.entity.BookType;

import java.util.List;

public interface BookTypeService {
    boolean save(BookTypeDTO bookTypeDto);
    List<BookType> findAll();
    BookType findById(int id);
    boolean remove(int id);
    boolean update(BookTypeDTO bookTypeDto, String bookTypeNameOld);
}
