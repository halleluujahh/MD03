package org.com.session13.repository;

import org.com.session13.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    boolean save(Employee employee);
}
