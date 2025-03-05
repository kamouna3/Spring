package com.example.spring_boot_intellij_ce.controller;

import com.example.spring_boot_intellij_ce.services.OrderService;
import com.example.spring_boot_intellij_ce.model.Order;
import com.example.spring_boot_intellij_ce.services.OrderPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dmn/orders")
public class OrderController  {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderPublisher orderPublisher;

    @PostMapping
    public String createOrder(@RequestBody Order order) throws Exception {
        orderPublisher.publishOrder(order);
        return "Order published";
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}