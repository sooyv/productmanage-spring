package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

}
