package org.com.dto.mapper;

public interface Mapper<R, E, P> {
    E mapperRequestToEntity(R entity);
    P mapperEntityToResponse(E entity);
}
