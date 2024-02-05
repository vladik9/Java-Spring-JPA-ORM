package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.app.User.User;
import com.example.app.User.UserRepository;

@SpringBootApplication
public class AppSortingAndPaginating {

     public static void main(String[] args) {
          SpringApplication.run(AppApplication.class, args);
     }

     // this will run after app starts and will run a cmd line runner that will
     // create a user and add it in DB, need to mark as bea as this will be used by
     // Hibernate to identify it
     @Bean
     CommandLineRunner commandLineRunnerAppSortingData(UserRepository userRepository) {
          return args -> {
               // System.out.println("Inside of sorting command line runner");
               // using sorting app run
               // sorting and paginating, using default JPA functionality
               // Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
               // userRepository.findAll(sort).forEach(u ->
               // System.out.println(u.getFirstName()));

               // Using pagination
               // 1 page and get 10 results
               // PageRequest pageRequest = PageRequest.of(0, 10, sort);
               // Page<User> page = userRepository.findAll(pageRequest);

               // System.out.println(page);
               // page.stream().forEach(
               // u -> System.out.println(u.getFirstName()));
          };
     }

}
