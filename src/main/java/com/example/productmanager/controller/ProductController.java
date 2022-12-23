package com.example.productmanager.controller;

import com.example.productmanager.domain.Product;
import com.example.productmanager.service.ProductService;
import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String createForm() {
        return "home";
    }

    @GetMapping("/products/new")
    public String createProduct(ProductForm form) {
        return "products/createProduct";
    }

    @PostMapping("/products/new")
    public String create(ProductForm form) {
        System.out.println(form.getName());
        System.out.println(form.getPrice());
        System.out.println(form.getStock());

        Product product = new Product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStock(form.getStock());
        productService.createProduct(product);

        return "redirect:/";
    }

    @GetMapping("/products")
    public String list(Model model) {
        List<Product> products = productService.findProduct();
        model.addAttribute("products", products);
        return "products/productsList";
    }

    @GetMapping("/products/{no}/delete")
    public String deleteProduct(@PathVariable("no") Long no) {
        productService.delete(no);
        return "redirect:/products";
    }

    @GetMapping("/products/{no}/edit")
    public String updateProduct(@PathVariable("no") Long no, Model model) {
        Product product = productService.findOne(no).get();
        model.addAttribute("no", product.getNo());
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("stock", product.getStock());

        return "products/updateProduct";
    }

    @PostMapping("/products/{no}/edit")
    public String update(@PathVariable("no") Long no, Product product) {
//        System.out.println(product.getNo());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        System.out.println(product.getStock());
        product.setNo(no);
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setStock(product.getStock());
        productService.update(product);
        return "redirect:/products";
    }
}
