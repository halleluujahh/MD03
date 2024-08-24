package ra.validate.repository;

import ra.validate.model.Users;

import java.util.List;

public interface UserRepository {
    List<Users> listUsers();

    Users existUser(String userName, String password);

    boolean create(Users user);
}
