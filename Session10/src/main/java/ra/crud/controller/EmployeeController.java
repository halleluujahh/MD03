package ra.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.crud.model.Employee;
import ra.crud.service.DepartmentService;
import ra.crud.service.EmployeeService;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findAll")
    public String findAllEmployees(Model model) {
        model.addAttribute("listEmployees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/initCreate")
    public String initCreateEmployee(Model model) {
        //1. Khởi tạo đối tượng Employee map vào form nhập liêu
        model.addAttribute("employee", new Employee());
        //2. Lấy tất cả các phòng ban và add vào model
        model.addAttribute("listDepartments", departmentService.findAll());
        return "newEmployee";
    }
    @PostMapping("/create")
    public String createEmployee(Employee employee){
        boolean result = employeeService.create(employee);
        if(result){
            return "redirect:findAll";
        }
        return "error";
    }
}
