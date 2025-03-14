package com.example.spring_boot_intellij_ce.model;

import lombok.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private String currency;
}