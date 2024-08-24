package ra.validate.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.validate.model.Users;
import ra.validate.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> listUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();
    }

    @Override
    public Users existUser(String userName, String password) {
        Users users = null;
        try {
            users = entityManager.createQuery("from Users u where u.userName=:us and u.password=:p", Users.class)
                    .setParameter("us", userName)
                    .setParameter("p", password).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    @Transactional
    public boolean create(Users user) {
        try {
            entityManager.persist(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
