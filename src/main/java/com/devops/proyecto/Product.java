/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.devops.proyecto;

/**
 *
 * @author Junal
 */
public class Product {
    private Long id;
    private String name;
    private double price;

    public Product(Long id, String name, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId()      { return id; }
    public String getName()  { return name; }
    public double getPrice() { return price; }
}
