package org.com.session16.service.impl;

import lombok.AllArgsConstructor;
import org.com.session16.dto.request.BookTypeDTO;
import org.com.session16.entity.BookType;
import org.com.session16.repository.BookTypeRepository;
import org.com.session16.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeRepository bookTypeRepository;
    @Override
    public boolean save(BookTypeDTO bookTypeDto) {
        if(bookTypeRepository.findByName(bookTypeDto.getTypeName()) != null) {
            return false;
        }
        BookType bookType = BookType.builder()
                .typeName(bookTypeDto.getTypeName())
                .description(bookTypeDto.getDescription())
                .typeStatus(bookTypeDto.isTypeStatus())
                .build();
        return bookTypeRepository.save(bookType);
    }

    @Override
    public List<BookType> findAll() {
        return bookTypeRepository.findAll();
    }

    @Override
    public BookType findById(int id) {
        return bookTypeRepository.findById(id);
    }

    @Override
    public boolean remove(int id) {
        if(bookTypeRepository.findById(id) == null){
            return bookTypeRepository.remove(id);
        }
        return false;
    }

    @Override
    public boolean update(BookTypeDTO bookTypeDto, String bookTypeNameOld) {
        if(!bookTypeNameOld.equals(bookTypeDto.getTypeName())) {
            if(bookTypeRepository.findByName(bookTypeDto.getTypeName()) != null) {
                return false;
            }
        }
        BookType bookType = BookType.builder()
                .id(bookTypeDto.getId())
                .typeName(bookTypeDto.getTypeName())
                .description(bookTypeDto.getDescription())
                .typeStatus(bookTypeDto.isTypeStatus())
                .build();
        return bookTypeRepository.update(bookType);
    }
}
