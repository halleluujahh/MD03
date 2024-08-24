package ra.validate.mapper;

import org.springframework.stereotype.Component;
import ra.validate.dto.request.RegisterDTO;
import ra.validate.model.Users;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class RegisterMapper<P> implements GenericMapper<RegisterDTO, Users, P> {


    @Override
    public Users mapperRequestToEntity(RegisterDTO requestDTO) {
        return Users.builder().userName(requestDTO.getUserName())
                .password(requestDTO.getPassword())
                .fullName(requestDTO.getFullName())
                .email(requestDTO.getEmail())
                .phone(requestDTO.getPhone())
                .sex(requestDTO.isSex())
                .birthDate(requestDTO.getBirthDate())
                .address(requestDTO.getAddress())
                .created(new Date())
                .status(true).build();
    }

    @Override
    public P mapperEntityToResponse(Users entity) {
        return null;
    }
}
