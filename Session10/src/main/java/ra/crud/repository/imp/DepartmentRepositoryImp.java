package ra.crud.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.crud.repository.DepartmentRepository;
import ra.crud.model.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentRepositoryImp implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> findAll() {
        return entityManager.createQuery("from Department", Department.class).getResultList();
    }

    @Override
    public Department findById(int id) {
        return entityManager.createQuery("from Department d where d.deptId = :id", Department.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Department department) {
        try {
            entityManager.persist(department);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Department department) {
        try {
            entityManager.merge(department);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            //Lấy đối tượng cần xóa
            Department dept = entityManager.find(Department.class, id);
            //Xóa
            entityManager.remove(dept);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
