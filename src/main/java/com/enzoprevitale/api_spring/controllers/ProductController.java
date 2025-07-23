package com.enzoprevitale.api_spring.controllers;

import com.enzoprevitale.api_spring.dtos.ProductDto;
import com.enzoprevitale.api_spring.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enzoprevitale.api_spring.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products") // Endpoint
public class ProductController {

    @Autowired // Instancia o ProductRepository repository automaticamente
    ProductRepository repository;

    @GetMapping // Mapeia métodos GET
    public ResponseEntity<List<Product>> getAll() {
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @GetMapping("/{id}") // Endereça o método GET ao endpoint /products/{id}
    public ResponseEntity getProduct(@PathVariable(value = "id") Integer id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }

    @PostMapping // Mapeia métodos POST
    public ResponseEntity<Product> postProduct(@RequestBody ProductDto dto) { // @RequestBody cria obrigatoriedade de objeto Product no corpo da requisição
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }

    @DeleteMapping("/{id}") // Mapeia métodos DELETE
    public ResponseEntity deleteProduct(@PathVariable(value = "id") Integer id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        repository.delete(product.get());
        return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
    }
}
