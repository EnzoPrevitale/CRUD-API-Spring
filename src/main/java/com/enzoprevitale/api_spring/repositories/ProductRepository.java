package com.enzoprevitale.api_spring.repositories;

import com.enzoprevitale.api_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
