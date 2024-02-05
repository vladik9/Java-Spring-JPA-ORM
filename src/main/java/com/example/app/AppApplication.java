package com.example.app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.User.User;
import com.example.app.User.UserRepository;
import com.example.app.UserId.UserId;
import com.example.app.UserId.UserIdRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	// this will run after app starts and will run a cmd line runner that will
	// create a user and add it in DB, need to mark as bea as this will be used by
	// Hibernate to identify it
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, UserIdRepository userIdRepository) {
		return args -> {
			generateAndSaveFakeUsers(userIdRepository);
		};

	}

	private void generateAndSaveFakeUsers(UserIdRepository userIdRepository) {

		List<User> userList = AppApplicationFakerUseGenerator.generateFakeUsers();

		for (User user : userList) {
			Faker faker = new Faker();
			// generating fake id's and fake user's + saving them

			userIdRepository.save(new UserId(faker.idNumber().valid().substring(0, 7), user));
		}

	}

}
