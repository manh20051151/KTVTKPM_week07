package com.example.User;

import com.example.User.models.User;
import com.example.User.repositories.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserApplication {

	@Autowired
	private UserRepositoty userRepositoty;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i=1; i<=10;i++){
					userRepositoty.save(new User(i,"user"+i));
				}
			}
		};
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
