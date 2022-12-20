package com.example.productmanager.service;


import com.example.productmanager.domain.Product;
import com.example.productmanager.repository.MemoryProductRepository;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //service - memberRepositort, service는 memberRepositort에 종속,
//    private final ProductRepository productRepository = new MemoryProductRepository();

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //product 등록
    public Long createProduct(Product product) {
        productRepository.save(product);
        return product.getNo();
    }

    //product 조회
    public List<Product> findProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findOne(Long productNo) {
        return productRepository.findByNo(productNo);
    }

    public Optional<Product> findName(String productName) {
        return productRepository.findByName(productName);
    }

}
