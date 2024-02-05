package com.example.app.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

//user repository that will support user CRUD extended from JPA REPO
public interface UserRepository extends JpaRepository<User, Long> {
     // optional custom functions if you don't like existing ones
     // find findUserByEmail (one user)
     @Query("SELECT u FROM User u WHERE u.email = ?1") // ?1 is the first parameter (email)
     Optional<User> findUserByEmail(String email);

     // find all by name
     @Query("SELECT u FROM User u WHERE u.firstName = ?1")
     // of query data provided
     // by (JPQL) or
     // Java Persistence Query Language

     List<User> findByFirstName(String firstName);

     @Query("SELECT u FROM User u WHERE u.firstName = ?1 AND u.age = ?2") // ?2 second parameter, controlled way
     List<User> findByFirstNameAndAge(String firstName, Integer age);

     @Query("SELECT u FROM User u")
     List<User> getAllUsers();

     // Native queries, classic queries accepted by DB,
     // ? warning this is DB specific, will not work for other dbs
     @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
     Optional<User> findUserById(Long id);

     // using named parameters, not question mark and parameter name firstName is
     // function parameter and now order of params in function call doesn't play role
     @Query(value = "SELECT * FROM user WHERE first_name = :firstName AND age = :userAge", nativeQuery = true)
     Optional<User> findUserBySpecialFirstName(@Param("firstName") String firstName,
               @Param("userAge") Integer userAge);

     // deleting an row from table,
     // JPA to Map anything back
     @Transactional // this will tell JPA this is a transaction
     @Modifying // need to mark with annotation Modifying to prevent any data return from DB
     @Query("DELETE FROM User u WHERE u.id = ?1")
     int deleteUserById(Long id);
}
