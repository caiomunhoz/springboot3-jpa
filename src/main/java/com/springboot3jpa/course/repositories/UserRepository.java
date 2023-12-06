package com.springboot3jpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3jpa.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
