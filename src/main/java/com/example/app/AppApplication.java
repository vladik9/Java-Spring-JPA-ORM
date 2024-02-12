package com.example.app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.app.Account.Account;
import com.example.app.Account.AccountRepository;
import com.example.app.User.User;
import com.example.app.User.UserRepository;
import com.example.app.UserCode.UserCode;
import com.example.app.UserCode.UserCodeRepository;
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
	CommandLineRunner commandLineRunner(UserRepository userRepository, UserCodeRepository userIdRepository,
			AccountRepository accountRepository) {
		return args -> {
			// generateAndSaveFakeUsers(userIdRepository, 10);
			// PageRequest pageRequest = PageRequest.of(0, 5);
			// Page<User> page = userRepository.findAll(pageRequest);
			// System.out.println(page.getContent());
			// System.out.println("User");
			// userRepository.findById(1L).ifPresent((u) -> System.out.println(u));
			// System.out.println("UserId");
			// userIdRepository.findById(1L).ifPresent((u) -> System.out.println(u))
			User newUser = new User("El Viva", "Macho", "el.viva@em.com", 34);
			userRepository.save(newUser);
			Account newAccount = new Account("12.12.2222", 100L, newUser);
			System.out.println(newAccount);
			accountRepository.save(newAccount);

		};

	}

	private void generateAndSaveFakeUsers(UserCodeRepository userIdRepository, int records) {

		List<User> userList = AppApplicationFakerUseGenerator.generateFakeUsers(10);

		for (User user : userList) {
			Faker faker = new Faker();
			// generating fake id's and fake user's + saving them

			userIdRepository.save(new UserCode(faker.idNumber().valid().substring(0, 6), user));
		}

	}

}
