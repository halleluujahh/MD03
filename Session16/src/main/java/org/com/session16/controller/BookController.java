package org.com.session16.controller;

import lombok.AllArgsConstructor;
import org.com.session16.dto.mapper.impl.MapperBook;
import org.com.session16.dto.request.BookDTO;
import org.com.session16.service.BookService;
import org.com.session16.service.BookTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/BookController")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookTypeService bookTypeService;
    private final MapperBook mapperBook;

    @GetMapping("/findAll")
    public String viewBooks(Model model) {
        model.addAttribute("listBook", bookService.findAll());
        return "listBook";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new BookDTO());
        model.addAttribute("listBookType", bookTypeService.findAll());
        return "createBook";
    }

    @PostMapping("/doCreate")
    public String createBook(Model model, @Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listBookType", bookTypeService.findAll());
            return "createBook";
        }
        boolean re = bookService.save(bookDTO);
        if (re) {
            return "redirect:findAll";
        }
        model.addAttribute("name", "Tên không được trùng !");
        return "createBook";
    }

    @GetMapping("/update")
    public String updateBook(Model model, @ModelAttribute("bookId") String bookId) {
        model.addAttribute("book", mapperBook.mapperEntityToResponse(bookService.findById(bookId)));
        model.addAttribute("listBookType", bookTypeService.findAll());
        if(model.asMap().get("name")!=null){
            model.addAttribute("name", model.asMap().get("name"));
        }
        return "updateBook";
    }

    @PostMapping("/doUpdate")
    public String doUpdateBook(RedirectAttributes redirectAttributes, @RequestParam("bookNameOld") String bookNameOld, Model model, @Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listBookType", bookTypeService.findAll());
            return "updateBook";
        }
        boolean re = bookService.update(bookDTO, bookNameOld);
        if (re) {
            return "redirect:findAll";
        }
        redirectAttributes.addFlashAttribute("name", "Tên không được trùng !");
        redirectAttributes.addFlashAttribute("bookId", bookDTO.getId());
        return "redirect:update";
    }

    @GetMapping("/delete")
    public String doUpdateBook(Model model, @RequestParam("bookId") String bookId) {
        boolean re = bookService.remove(bookId);
        if (re) {
            return "redirect:findAll";
        }
        model.addAttribute("url", "/BookController/findAll");
        return "error";
    }
}
