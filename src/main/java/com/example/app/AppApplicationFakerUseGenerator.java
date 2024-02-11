package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.User.User;
import com.example.app.User.UserRepository;
import com.github.javafaker.Faker;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication

public class AppApplicationFakerUseGenerator {

     public static void main(String[] args) {
          SpringApplication.run(AppApplication.class, args);
     }

     // this will run after app starts and will run a cmd line runner that will
     // create a user and add it in DB, need to mark as bea as this will be used by
     // Hibernate to identify it
     @Bean
     CommandLineRunner commandLineRunnerFakeUsersGenerator(UserRepository userRepository) {
          return args -> {
               // using faker app run

               // generateFakeUsers(userRepository);
          };

     }

     public static List<User> generateFakeUsers(int records) {
          Faker faker = new Faker();
          List<User> users = new ArrayList<>();
          for (int i = 0; i < records; i++) {
               String firstName = faker.name().firstName();
               String secondName = faker.name().lastName();
               String email = String.format("%s.%s@em.com", firstName, secondName);
               Integer age = faker.number().numberBetween(18, 35);
               // userRepository.save(new User(firstName, secondName, email, age));
               users.add(new User(firstName, secondName, email, age));
          }
          return users;

     }

}
