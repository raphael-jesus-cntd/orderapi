package com.example.orderapi.service;

import com.example.orderapi.model.Order;
import com.example.orderapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        if (orderRepository.existsByControlNumber(order.getControlNumber())) {
            throw new IllegalArgumentException("Control number already exists");
        }

        if (order.getRegistrationDate() == null) {
            order.setRegistrationDate(LocalDateTime.now());
        }

        if (order.getQuantity() == 0) {
            order.setQuantity(1);
        }

        BigDecimal discount = BigDecimal.ZERO;
        if (order.getQuantity() >= 10) {
            discount = BigDecimal.valueOf(0.10);
        } else if (order.getQuantity() > 5) {
            discount = BigDecimal.valueOf(0.05);
        }

        BigDecimal totalPrice = order.getUnitPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
        totalPrice = totalPrice.subtract(totalPrice.multiply(discount));
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
