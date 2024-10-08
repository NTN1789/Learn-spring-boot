package com.example.demo;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication   implements CommandLineRunner {
		// não esquecer de implementar o CommandLineRunner sempre
	@Autowired		// injetar algo
	private CategoryRepository  categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Electronics");
		Category cat2 = new Category(null,"Books");

		Product p1 = new Product(null,"TV",2200.00,cat1);
		Product p2 = new Product(null,"Doamin Driven Design", 120.00,cat2);
		Product p3 = new Product(null,"PS5", 2800.00,cat1);
		Product p4 = new Product(null, "Docker", 100.00,cat2);


		cat1.getProducts().addAll(Arrays.asList(p1,p3)); // acessar a listar e adicionar vários elementos ao mesmo tempo
															// addall => adicionar vários  elementos ao mesmo tempo e o Arrays.asList está fazendo em lista
		cat2.getProducts().addAll(Arrays.asList(p2,p4));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);

		// fazer o ProductResource para ter os endpointers

	}
}
