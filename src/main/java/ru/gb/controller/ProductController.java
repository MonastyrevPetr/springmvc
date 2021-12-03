package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.dto.Product;
import ru.gb.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProduct(Model model){
        model.addAttribute("products",productService.getAll());
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findId(id));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddForm(){
        return "product_form";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam Integer id, @RequestParam String title, @RequestParam Integer cost){
        productService.save(new Product(id,title,cost));
        return "redirect:all";
    }
}
