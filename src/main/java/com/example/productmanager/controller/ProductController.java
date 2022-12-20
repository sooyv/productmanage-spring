package com.example.productmanager.controller;

import com.example.productmanager.domain.Product;
import com.example.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/new")
    public String createForm() {
        return "products/createProduct";
    }

    @PostMapping("/products/new")
    public String create(ProductForm form) {
        Product product = new Product();
        product.setNo(form.getNo());
        product.setName(form.getName());

        productService.createProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String list(Model model) {
        List<Product> products = productService.findProduct();
        model.addAttribute("products", products);
        return "products/productList";
    }
}
