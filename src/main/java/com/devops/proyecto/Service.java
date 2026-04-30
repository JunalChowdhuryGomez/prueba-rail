/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.devops.proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Junal
 */
@org.springframework.stereotype.Service
public class Service {
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> findAll() {
        return products;
    }

    public Product save(String name, double price) {
        Product p = new Product(nextId++, name, price);
        products.add(p);
        return p;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

}
