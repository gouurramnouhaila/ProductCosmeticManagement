package com.example.demoservice;

import com.example.demoservice.model.Category;
import com.example.demoservice.model.Command;
import com.example.demoservice.model.Product;
import com.example.demoservice.model.User;
import com.example.demoservice.repository.CategoryRepository;
import com.example.demoservice.repository.CommandRepository;
import com.example.demoservice.repository.ProductRepository;
import com.example.demoservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoServiceApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	private final ProductRepository productRepository;

	private final CategoryRepository categoryRepository;

	private final CommandRepository commandRepository;

	public DemoServiceApplication(
			UserRepository userRepository,
			ProductRepository productRepository,
			CategoryRepository categoryRepository,
			CommandRepository commandRepository
	) {
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.commandRepository = commandRepository;
	}

	public static void main(String[] args) {

		System.out.println("hello");
		SpringApplication.run(DemoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null,"John Doe", "123 Main St", "john@example.com", "password123");
		User user2 = new User(null,"Jane Smith", "456 Elm St", "jane@example.com", "password456");
		User user3 = new User(null,"Mike Johnson", "789 Oak St", "mike@example.com", "password789");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		Category category1 = new Category(null,"Skincare", "Products for skincare routine", null);
		Category category2 = new Category(null,"Haircare", "Products for hair care", null);
		Category category3 = new Category(null,"Makeup", "Cosmetics for makeup", null);

		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);

		Product product1 = new Product(null,"Lotion", "Hydrating lotion", 10.99, 50,category1,"provider1");
		Product product2 = new Product(null,"Shampoo", "Moisturizing shampoo", 8.99, 30,category2,"provider2");
		Product product3 = new Product(null,"Lipstick", "Long-lasting lipstick", 12.99, 20,category3,"provider3");

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

		Command command = new Command(null,user1, products, new Date());

		commandRepository.save(command);
	}
}
