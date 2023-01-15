package com.example.gestioncommercial.repository;

import com.example.gestioncommercial.Entity.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProducts, Long> {


}
