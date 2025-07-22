package com.enzoprevitale.api_spring.model;

import jakarta.persistence.*;

@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id // Marca o atributo como Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indica que o valor será gerado automaticamente
    private Integer id; // Integer, String e Long são objetos
    private Long price;
    private String name;

    public Product(Integer id, Long price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
