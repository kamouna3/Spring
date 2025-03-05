package com.example.spring_boot_intellij_ce.model;

import lombok.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {
    private String street;
    private String city;
    private String postalCode;
    private String country;
}