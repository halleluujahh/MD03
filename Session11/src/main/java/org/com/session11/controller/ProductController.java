package org.com.session11.controller;

import lombok.AllArgsConstructor;
import org.com.session11.model.Product;
import org.com.session11.service.CategoryService;
import org.com.session11.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public String findAllProduct(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/create")
    public String createProduct(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "product-create";
    }

    @PostMapping("/doCreate")
    public String doCreateProduct(Product product, Model model){
        if(productService.save(product)){
            return "redirect:findAll";
        }
        else{
            return "redirect:error";
        }
    }

    @GetMapping("/update")
    public String updateProduct(@RequestParam(name = "prodId") Integer id, Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("product",(Product) productService.findById(id));
        return "product-update";
    }

    @PostMapping("/doUpdate")
    public String doUpdateProduct(Product product, Model model){
        if(productService.update(product)){
            return "redirect:findAll";
        }
        else{
            return "redirect:error";
        }
    }

    @GetMapping("delete")
    public String deleteProduct(@RequestParam(name = "prodId") Integer id){
        if(productService.delete(id)){
            return "redirect:findAll";
        }else {
            return "redirect:error";
        }
    }

    @GetMapping("/view-details")
    public String viewProductDetails(@RequestParam(name = "prodId") Integer id, Model model){
        Product product = productService.viewDetailsProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("category", categoryService.findById(product.getId()));
        return "product-details";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
