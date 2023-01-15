package com.example.gestioncommercial.service;


import com.example.gestioncommercial.Entity.Orders;
import com.example.gestioncommercial.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) throws Exception {
        Optional<Orders> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new Exception("Order not found");
        }
        return order.get();
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(Orders order, Long id) throws Exception {
        Optional<Orders> existingOrder = orderRepository.findById(id);
        if (!existingOrder.isPresent()) {
            throw new Exception("Order not found");
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) throws Exception {
        Optional<Orders> existingOrder = orderRepository.findById(id);
        if (!existingOrder.isPresent()) {
            throw new Exception("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
