package com.example.productmanager.service;

import com.example.productmanager.domain.Product;
import com.example.productmanager.repository.MemoryProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    ProductService productService;
    MemoryProductRepository productRepository;

    @BeforeEach
    public void beforeEach() {
        productRepository = new MemoryProductRepository();
        productService = new ProductService(productRepository);
    }

    @AfterEach
    public void afterEach() {
        productRepository.clearStore();
    }

    @Test
    public void 상품등록() throws Exception {
        //given
        Product product = new Product();
        product.setNo(0);
        product.setName("삼다수");
        //when
        Long saveNo = productService.createProduct(product);
//        String saveName = productService.createProduct(product);
        //then
        Product findProductNo = productRepository.findByNo(saveNo).get();
        assertEquals(product.getNo(), findProductNo.getNo());
//        Product findProductName = productRepository.findByName(saveName).get();
    }


}