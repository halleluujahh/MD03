package ra.crud.repository;

import ra.crud.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    boolean create(Employee employee);

}
