package com.springboot3jpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3jpa.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
