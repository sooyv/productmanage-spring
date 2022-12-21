package com.example.productmanager;

import com.example.productmanager.repository.ProductRepository;
import com.example.productmanager.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final ProductRepository productRepository;

    public SpringConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }
}
