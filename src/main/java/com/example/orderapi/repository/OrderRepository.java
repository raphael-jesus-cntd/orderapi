package com.example.orderapi.repository;

import com.example.orderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByControlNumber(String controlNumber);
}
