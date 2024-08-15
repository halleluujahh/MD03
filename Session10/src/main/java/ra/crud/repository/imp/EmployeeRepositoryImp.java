package ra.crud.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.crud.model.Employee;
import ra.crud.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee e order by e.department.deptId ASC", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public boolean create(Employee employee) {
        try {
            entityManager.persist(employee);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
