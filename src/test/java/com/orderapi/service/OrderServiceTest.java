package com.orderapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.orderapi.model.Order;
import com.example.orderapi.repository.OrderRepository;
import com.example.orderapi.service.OrderService;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createOrder_shouldApplyDiscountsCorrectly() {
        Order order = new Order();
        order.setControlNumber("12345");
        order.setProductName("Product 1");
        order.setUnitPrice(BigDecimal.valueOf(100));
        order.setQuantity(10);

        when(orderRepository.existsByControlNumber(order.getControlNumber())).thenReturn(false);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertEquals(BigDecimal.valueOf(900.0), createdOrder.getTotalPrice());
    }

    @Test
    void createOrder_shouldSetDefaults() {
        Order order = new Order();
        order.setControlNumber("12345");
        order.setProductName("Product 1");
        order.setUnitPrice(BigDecimal.valueOf(100));

        when(orderRepository.existsByControlNumber(order.getControlNumber())).thenReturn(false);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertEquals(1, createdOrder.getQuantity());
        assertNotNull(createdOrder.getRegistrationDate());
    }
}
