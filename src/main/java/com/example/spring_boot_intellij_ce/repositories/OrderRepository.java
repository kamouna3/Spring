package com.example.spring_boot_intellij_ce.repositories;

import com.example.spring_boot_intellij_ce.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}