package com.example.spring_boot_intellij_ce.model;

import com.example.spring_boot_intellij_ce.model.Item;
import com.example.spring_boot_intellij_ce.model.ShippingAddress;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String customerId;
    private List<Item> items;
    private ShippingAddress shippingAddress;
    private String paymentMethod;
    private double totalAmount;
    private String currency;
    private String status;
    private String createdAt;
}