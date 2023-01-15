package com.example.gestioncommercial.repository;

import com.example.gestioncommercial.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
