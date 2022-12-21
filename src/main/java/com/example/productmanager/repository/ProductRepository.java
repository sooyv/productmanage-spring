package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //jpa - update는 save로 가능
    Product save(Product product);

    Optional<Product> findByNo(long no);
    Optional<Product> findByName(String name);

    //price, stock은 필요X

    List<Product> findAll();

    void delete(Product product);

}
