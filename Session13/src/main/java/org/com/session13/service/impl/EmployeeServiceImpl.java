package org.com.session13.service.impl;

import org.com.session13.dto.request.EmployeeDTO;
import org.com.session13.model.Employee;
import org.com.session13.repository.EmployeeRepository;
import org.com.session13.service.EmployeeService;
import org.com.session13.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean create(EmployeeDTO employeeDTO) {
        //1. Upload File len firebase --> URL file trên firebase
        String avatarUrlFirebase = uploadFileService.uploadFileToLocal(employeeDTO.getAvatar());
        //2. Chuyển DTO --> entity
        Employee employee = Employee.builder().empName(employeeDTO.getEmpName())
                .empAge(employeeDTO.getAge())
                .avatar(avatarUrlFirebase)
                .build();
        //3. Gọi sang repository để thêm nhân viên
        return employeeRepository.save(employee);
    }
}
