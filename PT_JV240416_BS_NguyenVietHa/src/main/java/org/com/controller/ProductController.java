package org.com.controller;

import org.com.dto.mapper.impl.MapperProductImpl;
import org.com.dto.request.ProductDTO;
import org.com.entity.Product;
import org.com.service.CategoryService;
import org.com.service.ProductService;
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
@RequestMapping("/ProductController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MapperProductImpl mapperProductImpl;
    @GetMapping("/findAll")
    public String findAll(Model model) {
        if(productService.findAll(1,5).isEmpty()){
            model.addAttribute("msg", "Không có sản phẩm nào tồn tại");
            return "product";
        }
        model.addAttribute("pageNo", 1);
        model.addAttribute("totalPage", productService.findAll(0, 100000000).size()%5 == 0 ? productService.findAll(0, 100000000).size()/5 : productService.findAll(0, 100000000).size()/5+1);
        model.addAttribute("products", productService.findAll(1, 5));
        return "product";
    }

    @GetMapping(value = "/findAll", params = {"pageNo"})
    public String findAll(Model model, @ModelAttribute("pageNo") Integer pageNo) {
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPage", productService.findAll(0, 100000000).size()%5 == 0 ? productService.findAll(0, 100000000).size()/5 : productService.findAll(0, 100000000).size()/5+1);
        model.addAttribute("products", productService.findAll(pageNo, 5));
        return "product";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categoryL", categoryService.findAll(0,1000));
        return "productAdd";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("product") @Valid ProductDTO productDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "productAdd";
        }
        if(productService.save(productDTO)){
            return "redirect:findAll";
        }
        model.addAttribute("msg","Tên thể loại đã tồn tại");
        model.addAttribute("productDTO", productDTO);
        return "productAdd";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("prodId") Integer id, Model model) {
        Product p = productService.findById(id);
        model.addAttribute("product",ProductDTO.builder().id(p.getId()).name(p.getName()).price(p.getPrice()).status(p.isStatus()).category(p.getCategory()).description(p.getDescription()).build());
        model.addAttribute("categoryL", categoryService.findAll(0,1000));
        return "productUpdate";
    }

    @PostMapping("/doUpdate")
    public String doUpdate( @Valid @ModelAttribute("product") ProductDTO productDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryL", categoryService.findAll(0,1000));
            return "productUpdate";
        }
        if(productService.update(productDTO)){
            return "redirect:findAll";
        }
        model.addAttribute("msg","Tên sản phẩm đã tồn tại");
        model.addAttribute("product", productDTO);
        model.addAttribute("categoryL", categoryService.findAll(0,1000));

        return "productUpdate";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("prodId") Integer id, Model model) {
        if(productService.remove(id)){
            return "redirect:findAll";
        }
        model.addAttribute("error", "Thể loại này đã tồn tại sản phẩm");
        model.addAttribute("url", "/ProductController/findAll");
        return "error";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("searchByName") String name, Model model) {
        if(productService.findAllByName(name).isEmpty()){
            model.addAttribute("msg", "Không có sản phẩm nào tồn tại");
            return "product";
        }
        model.addAttribute("products", productService.findAllByName(name));
        return "product";
    }
}
