package com.springboot3jpa.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot3jpa.course.entities.User;
import com.springboot3jpa.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Ryan Gosling", "ryang@gmail.com", "999999999", "password");
		User u2 = new User(null, "Ana de Armas", "ana@outlook.com", "111111111", "password");

		userRepo.saveAll(Arrays.asList(u1, u2));
	}
}
