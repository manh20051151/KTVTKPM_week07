package com.example.Product;

import com.example.Product.models.Product;
import com.example.Product.repositories.ProductRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductApplication {

	@Autowired
	private ProductRepositoty productRepositoty;
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i=1; i<=10;i++){
					productRepositoty.save(new Product(i,"product"+i));
				}
			}
		};
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
