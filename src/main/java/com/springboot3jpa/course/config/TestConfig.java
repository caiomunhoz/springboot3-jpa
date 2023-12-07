package com.springboot3jpa.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot3jpa.course.entities.Order;
import com.springboot3jpa.course.entities.User;
import com.springboot3jpa.course.repositories.OrderRepository;
import com.springboot3jpa.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Ryan Gosling", "ryang@gmail.com", "999999999", "password");
		User u2 = new User(null, "Ana de Armas", "ana@outlook.com", "111111111", "password");
		
		Order o1 = new Order(null, Instant.parse("2023-12-01T09:32:27Z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-12-04T20:02:01Z"), u1);
		Order o3 = new Order(null, Instant.parse("2023-12-07T14:57:12Z"), u2);
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1, o2, o3));
	}
}
