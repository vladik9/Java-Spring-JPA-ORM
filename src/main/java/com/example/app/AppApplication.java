package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.user.User;
import com.example.app.user.UserRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	// this will run after app starts and will run a cmd line runner that will
	// create a user and add it in DB, need to mark as bea as this will be used by
	// Hibernate to identify it
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			// this or second
			User newUser = new User("Vlad", "Cor", "em@em.com", 27);
			userRepository.save(newUser);

			// User user = new User( "Vlad", "Cor", "em@em.com", 27);
			// userRepository.save(user);
		};
	}

}
