package ra.validate.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.validate.dto.request.LoginDTO;
import ra.validate.dto.request.RegisterDTO;
import ra.validate.mapper.RegisterMapper;
import ra.validate.model.Users;
import ra.validate.repository.UserRepository;
import ra.validate.service.UserService;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(RegisterDTO registerDTO) {
        //1. Chuyen tu loginDTO sang Users entity
        Users user = registerMapper.mapperRequestToEntity(registerDTO);
        //2. Goi sang repository them user
        boolean result = userRepository.create(user);
        //3. Tra ve controller
        return result;
    }

    @Override
    public Users existUser(String userName, String password) {
        return userRepository.existUser(userName, password);
    }
}
