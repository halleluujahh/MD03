package org.com.session13.controller;

import org.com.session13.dto.request.EmployeeDTO;
import org.com.session13.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public String findAllEmployee(Model model) {
        model.addAttribute("listEmps", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/initCreate")
    public String initCreateEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDTO());
        return "newEmployee";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDTO employeeDTO) {
        boolean result = employeeService.create(employeeDTO);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
