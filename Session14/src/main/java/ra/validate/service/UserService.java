package ra.validate.service;

import ra.validate.dto.request.LoginDTO;
import ra.validate.dto.request.RegisterDTO;
import ra.validate.model.Users;

import java.util.List;

public interface UserService {
    boolean create(RegisterDTO registerDTO);

    Users existUser(String userName, String password);
}
