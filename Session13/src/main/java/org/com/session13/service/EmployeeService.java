package org.com.session13.service;

import org.com.session13.dto.request.EmployeeDTO;
import org.com.session13.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    boolean create(EmployeeDTO employeeDTO);
}
