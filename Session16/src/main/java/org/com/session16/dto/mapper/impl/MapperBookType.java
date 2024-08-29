package org.com.session16.dto.mapper.impl;

import org.com.session16.dto.mapper.Mapper;
import org.com.session16.dto.request.BookTypeDTO;
import org.com.session16.entity.BookType;
import org.springframework.stereotype.Component;

@Component
public class MapperBookType implements Mapper<BookTypeDTO, BookType, BookTypeDTO> {
    @Override
    public BookType mapperRequestToEntity(BookTypeDTO entity) {
        return BookType.builder()
                .typeName(entity.getTypeName())
                .description(entity.getDescription())
                .typeStatus(entity.isTypeStatus())
                .build();
    }

    @Override
    public BookTypeDTO mapperEntityToResponse(BookType entity) {
        return BookTypeDTO.builder()
                .id(entity.getId())
                .typeName(entity.getTypeName())
                .description(entity.getDescription())
                .typeStatus(entity.isTypeStatus())
                .build();
    }
}
