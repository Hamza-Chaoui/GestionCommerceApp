package com.example.gestioncommercial.service;


import com.example.gestioncommercial.Entity.Products;
import com.example.gestioncommercial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) throws Exception {
        Optional<Products> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new Exception("Product not found");
        }
        return product.get();
    }

    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Products product, Long id) throws Exception {
        Optional<Products> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            throw new Exception("Product not found");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) throws Exception {
        Optional<Products> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            throw new Exception("Product not found");
        }
        productRepository.deleteById(id);
    }
}
