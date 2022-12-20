package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findByNo(long no);
    Optional<Product> findByName(String name);

    //price, stock은 필요X

    List<Product> findAll();
}
