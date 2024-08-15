package ra.crud.service;

import ra.crud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    boolean create(Employee employee);
}
