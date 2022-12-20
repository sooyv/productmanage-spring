package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositoryTest {
    MemoryProductRepository repository = new MemoryProductRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Product product = new Product();
        product.setNo(0);

        //when
        repository.save(product);

        //then
        Product result = repository.findByNo(product.getNo()).get();
        assertThat(result).isEqualTo(product);
    }

    @Test
    public void findByNo() {
        //given
        Product product1 = new Product();
        product1.setName("삼다수");
        product1.setPrice(3000);
        product1.setStock(20);
        repository.save(product1);

        Product product2 = new Product();
        repository.save(product2);

        //when
        Product result = repository.findByNo(product1.getNo()).get();

        //then
        assertThat(result).isEqualTo(product1);
    }

    @Test
    public void findAll() {
        //given
        Product product1 = new Product();
        product1.setNo(0);
        repository.save(product1);

        Product product2 = new Product();
        product2.setNo(1);
        repository.save(product2);

        //when
        List<Product> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);

    }

}