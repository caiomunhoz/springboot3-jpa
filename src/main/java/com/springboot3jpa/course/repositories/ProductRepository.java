package com.springboot3jpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3jpa.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
