package ra.validate.mapper;

//R: RequestDTO
//E: Entity
//P: ResponseDTO
public interface GenericMapper<R, E, P> {
    //1. RequestDTO --> Entity
    E mapperRequestToEntity(R requestDTO);

    //2. Entity --> ResponseDTO
    P mapperEntityToResponse(E entity);
}
