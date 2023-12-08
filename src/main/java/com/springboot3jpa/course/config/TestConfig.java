package com.springboot3jpa.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot3jpa.course.entities.Category;
import com.springboot3jpa.course.entities.Order;
import com.springboot3jpa.course.entities.OrderItem;
import com.springboot3jpa.course.entities.Payment;
import com.springboot3jpa.course.entities.Product;
import com.springboot3jpa.course.entities.User;
import com.springboot3jpa.course.entities.enums.OrderStatus;
import com.springboot3jpa.course.repositories.CategoryRepository;
import com.springboot3jpa.course.repositories.OrderItemRepository;
import com.springboot3jpa.course.repositories.OrderRepository;
import com.springboot3jpa.course.repositories.ProductRepository;
import com.springboot3jpa.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Gaming");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "240Hz monitor", "Nulla eu imperdiet purus. Maecenas ante.", 700.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "GTX 1070", "Donec aliquet odio ac rhoncus cursus.", 800.0, "");
		Product p5 = new Product(null, "Hunger Games", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Ryan Gosling", "ryang@gmail.com", "999999999", "password");
		User u2 = new User(null, "Ana de Armas", "ana@outlook.com", "111111111", "password");
		
		Order o1 = new Order(null, Instant.parse("2023-12-01T09:32:27Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2023-12-04T20:02:01Z"), OrderStatus.CANCELLED, u1);
		Order o3 = new Order(null, Instant.parse("2023-12-07T14:57:12Z"), OrderStatus.PAID, u2);
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepo.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2023-12-07T15:57:12Z"), o3);
		o1.setPayment(pay1);
		
		orderRepo.save(o1);
	}
}
