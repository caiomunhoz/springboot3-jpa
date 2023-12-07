package com.springboot3jpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3jpa.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
