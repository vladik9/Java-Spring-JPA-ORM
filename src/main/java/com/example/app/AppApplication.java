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

			User user = new User("Vlad", "Cor", "em@em.com", 26);
			// userRepository.save(user);
			// use optional field that has been declared in userRepository to get a db query
			// for getting that user whit email
			String users = userRepository.findByFirstName("Vlad").toString();
			System.out.println(users);

			System.out.println("Searching by age");
			userRepository.findByFirstNameAndAge("Vlad", 26).stream().forEach(System.out::println);

			System.out.println("End of file, get all users");
			userRepository.getAllUsers().stream().forEach(System.out::println);

			// get user number six
			System.out.println("User number six is: ");
			userRepository.findUserById(6L).stream().forEach(System.out::println);

			// using named parameters;
			userRepository.findUserBySpecialFirstName("Vladd", 26).stream().forEach((u) -> System.out.println(u));

			// deleting records

			System.out.println(userRepository.deleteUserById(14L));
		};
	}

}
