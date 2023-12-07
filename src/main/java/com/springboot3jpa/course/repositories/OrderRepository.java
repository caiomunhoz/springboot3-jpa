package com.springboot3jpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3jpa.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
