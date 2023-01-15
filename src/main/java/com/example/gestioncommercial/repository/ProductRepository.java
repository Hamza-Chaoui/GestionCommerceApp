package com.example.gestioncommercial.repository;

import com.example.gestioncommercial.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
