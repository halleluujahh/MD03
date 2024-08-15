package ra.crud.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.crud.model.Employee;
import ra.crud.repository.EmployeeRepository;
import ra.crud.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }
}
