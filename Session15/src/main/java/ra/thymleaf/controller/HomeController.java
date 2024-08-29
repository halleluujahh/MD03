package ra.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.thymleaf.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/homeController")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("rs", "phần mềm");
        model.addAttribute("ra", "CNTT");
        model.addAttribute("student", new Student("SV001", "Nguyễn Văn A", 18, true));
        List<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("SV001", "Nguyễn Văn A", 18, true));
        listStudents.add(new Student("SV002", "Nguyễn Văn B", 22, false));
        listStudents.add(new Student("SV003", "Nguyễn Văn C", 20, true));
        model.addAttribute("listStudents", listStudents);
        return "home";
    }
}
