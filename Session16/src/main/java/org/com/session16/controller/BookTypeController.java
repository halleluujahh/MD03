package org.com.session16.controller;

import lombok.AllArgsConstructor;
import org.com.session16.dto.mapper.impl.MapperBookType;
import org.com.session16.dto.request.BookTypeDTO;
import org.com.session16.service.BookTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/BookTypeController")
@AllArgsConstructor
public class BookTypeController {
    private final BookTypeService bookTypeService;
    private final MapperBookType mapperBookType;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("bookTypeList", bookTypeService.findAll());
        return "listBookType";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookType", new BookTypeDTO());
        return "createBookType";
    }

    @PostMapping("/doCreate")
    public String doCreate(Model model, @Valid @ModelAttribute("bookType") BookTypeDTO bookTypeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createBookType";
        }
        if (bookTypeService.save(bookTypeDTO)) {
            return "redirect:findAll";
        }
        model.addAttribute("name", "Tên không được trùng !");
        return "createBookType";
    }

    @GetMapping("/update")
    public String update(Model model, @ModelAttribute("bookTypeId") Integer bookTypeId) {
        model.addAttribute("bookType", mapperBookType.mapperEntityToResponse(bookTypeService.findById(bookTypeId)));
        if (model.asMap().get("name") != null) {
            model.addAttribute("name", model.asMap().get("name"));
        }
        return "updateBookType";
    }

    @PostMapping("/doUpdate")
    public String doUpdate(RedirectAttributes redirectAttributes, @RequestParam("bookTypeNameOld") String bookTypeNameOld, Model model, @Valid @ModelAttribute("bookType") BookTypeDTO bookTypeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateBookType";
        }
        if (bookTypeService.update(bookTypeDTO, bookTypeNameOld)) {
            return "redirect:findAll";
        }
        redirectAttributes.addFlashAttribute("name", "Tên không được trùng !");
        redirectAttributes.addFlashAttribute("bookTypeId", bookTypeDTO.getId());

        return "redirect:update";
    }

    @GetMapping("/delete")
    public String delete(Model model,@RequestParam("bookTypeId") Integer bookTypeId) {
        if (bookTypeService.remove(bookTypeId)) {
            return "redirect:findAll";
        }
        model.addAttribute("url", "/BookTypeController/findAll");
        model.addAttribute("error","Thể loại sách này đã tồn tại sách");
        return "error";
    }
}
