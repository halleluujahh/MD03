package ra.crud.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.crud.model.Department;
import ra.crud.repository.DepartmentRepository;
import ra.crud.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean create(Department department) {
        return departmentRepository.create(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentRepository.update(department);
    }

    @Override
    public boolean delete(int id) {
        return departmentRepository.delete(id);
    }
}
