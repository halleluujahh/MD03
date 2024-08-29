package org.com.controller;

import org.com.dto.request.CategoryDTO;
import org.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/CategoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        if(categoryService.findAll(1,5).isEmpty()){
            model.addAttribute("msg", "Không có thể loại nào tồn tại");
            return "category";
        }
        model.addAttribute("pageNo", 1);
        model.addAttribute("totalPage", categoryService.findAll(0, 100000000).size()%5 == 0 ? categoryService.findAll(0, 100000000).size()/5 : categoryService.findAll(0, 100000000).size()/5+1);
        model.addAttribute("categories", categoryService.findAll(1, 5));
        return "category";
    }

    @GetMapping(value = "/findAll", params = {"pageNo"})
    public String findAll(Model model, @ModelAttribute("pageNo") Integer pageNo) {
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPage", categoryService.findAll(0, 100000000).size()%5 == 0 ? categoryService.findAll(0, 100000000).size()/5 : categoryService.findAll(0, 100000000).size()/5+1);
        model.addAttribute("categories", categoryService.findAll(pageNo, 5));
        return "category";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new CategoryDTO());
        return "categoryAdd";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("category") @Valid CategoryDTO categoryDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categoryAdd";
        }
        if(categoryService.save(categoryDTO)){
            return "redirect:findAll";
        }
        model.addAttribute("msg","Tên thể loại đã tồn tại");
        model.addAttribute("CategoryDTO", categoryDTO);
        return "categoryAdd";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("cateId") Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "categoryUpdate";
    }

    @PostMapping("/doUpdate")
    public String doUpdate(@ModelAttribute("category") @Valid CategoryDTO categoryDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categoryUpdate";
        }
        if(categoryService.update(categoryDTO)){
            return "redirect:findAll";
        }
        model.addAttribute("msg","Tên thể loại đã tồn tại");
        model.addAttribute("category", categoryDTO);
        return "categoryUpdate";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("cateId") Integer id, Model model) {
        if(categoryService.remove(id)){
            return "redirect:findAll";
        }
        model.addAttribute("error", "Thể loại này đã tồn tại sản phẩm");
        model.addAttribute("url", "/CategoryController/findAll");
        return "error";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("searchByName") String name, Model model) {
        if(categoryService.findByName(name).isEmpty()){
            model.addAttribute("msg", "Không có thể loại nào tồn tại");
            return "category";
        }
        model.addAttribute("categories", categoryService.findByName(name));
        return "category";
    }
}
