package org.com.session11.controller;

import lombok.AllArgsConstructor;
import org.com.session11.model.Category;
import org.com.session11.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/findAll")
    public String findAllCategory(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "category-create";
    }

    @PostMapping("/doCreate")
    public String doCreateCategory(Category category, Model model){
        if(categoryService.save(category)){
            return "redirect:/category/findAll";
        }
        else{
            return "redirect:error";
        }
    }

    @GetMapping("/update")
    public String updateCategory(@RequestParam(name = "cateId") Integer id, Model model){
        model.addAttribute("category",(Category) categoryService.findById(id));
        return "category-update";
    }

    @PostMapping("/doUpdate")
    public String doUpdateCategory(Category category, Model model){
        if(categoryService.update(category)){
            return "redirect:/category/findAll";
        }
        else{
            return "redirect:error";
        }
    }

    @GetMapping("delete")
    public String deleteCategory(@RequestParam(name = "cateId") Integer id){
        if(categoryService.delete(id)){
            return "redirect:/category/findAll";
        }else {
            return "redirect:error";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

}
