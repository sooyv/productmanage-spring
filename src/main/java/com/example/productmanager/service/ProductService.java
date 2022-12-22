package com.example.productmanager.service;


import com.example.productmanager.controller.ProductForm;
import com.example.productmanager.domain.Product;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public void delete(Long no) {
        Product product = productRepository.findByNo(no).get();
        productRepository.delete(product);
    }

    @Transactional
    public void update(Product product) {
        Product productToUpdate = productRepository.findByNo(product.getNo()).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
    }
}
