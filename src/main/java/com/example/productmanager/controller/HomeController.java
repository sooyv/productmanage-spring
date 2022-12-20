package com.example.productmanager.controller;

import com.example.productmanager.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public Product home() {
    Product product = new Product();
    product.setName("삼다수");
    product.setPrice(900);
    product.setStock(20);
    return product;
    }
}
