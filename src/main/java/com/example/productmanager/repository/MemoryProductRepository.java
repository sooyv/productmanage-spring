package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MemoryProductRepository implements ProductRepository {

    private static Map<Long, Product> store = new HashMap<>();
    private static long sepuence = 0L;

    @Override
    public Product save(Product product) {
        product.setNo(++sepuence);
        store.put(product.getNo(), product);
        return product;
    }

    @Override
    public Optional<Product> findByNo(long no) {
        return Optional.ofNullable(store.get(no));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
