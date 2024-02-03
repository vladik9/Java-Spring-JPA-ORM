package com.example.app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//user repository that will support user CRUD extended from JPA REPO
public interface UserRepository extends JpaRepository<User, Long> {
     // optional custom functions if you don't like existing ones
     // find findUserByEmail one user
     @Query("SELECT u FROM User u WHERE u.email = ?1") // ?1 is the first parameter (email)
     Optional<User> findUserByEmail(String email);

     // find all by name
     @Query("SELECT u FROM User u WHERE u.firstName = ?1")
     // of query data provided
     // by (JQPL) or
     // JavaPersistence Query Language

     List<User> findByFirstName(String firstName);

     @Query("SELECT u FROM User u WHERE u.firstName = ?1 AND u.age = ?2") // ?2 second parameter, controlled way
     List<User> findByFirstNameAndAge(String firstName, Integer age);

     @Query("SELECT u FROM User u")
     List<User> getAllUsers();

     // Native queries, classic queries accepted by DB,
     // ? warning this is DB specific, will not work for other dbs
     @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
     Optional<User> findUserById(Long id);

}
