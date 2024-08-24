package ra.validate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.validate.dto.request.LoginDTO;
import ra.validate.dto.request.RegisterDTO;
import ra.validate.model.Users;
import ra.validate.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/initLogin")
    public String initLogin(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @GetMapping("/initRegister")
    public String initRegister(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterDTO registerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        //Thêm user vào db
        boolean result = userService.create(registerDTO);
        if (result) {
            return "redirect:initLogin";
        }
        return "error";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginDTO loginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Users users = userService.existUser(loginDTO.getUserName(), loginDTO.getPassword());
        if (users != null) {
            return "home";
        }
        return "redirect:initLogin";
    }
}
