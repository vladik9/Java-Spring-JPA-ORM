package com.example.app.User;

import java.util.List;

import com.example.app.Account.Account;
import com.example.app.UserCode.UserCode;

import jakarta.persistence.Column;
//jakarta app
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "User") // This tells Hibernate to make a table out of this class
// this helps to specify table constraints for uniqueness in table
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(name = "user_email_unique", columnNames = "email") })
public class User {
     // this is primary key or identifier in DB
     @Id
     // sequence generator
     @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
     // this points to sequence generator to generate a value for this table
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
     // column is used to specify individual properties for columns in SQL table
     @Column(name = "id", updatable = false)
     private Long id;
     @Column(name = "firstName", updatable = true, nullable = false, columnDefinition = "TEXT")
     private String firstName;
     @Column(name = "secondName", updatable = true, nullable = false, columnDefinition = "TEXT")
     private String secondName;
     @Column(name = "email", updatable = false, nullable = false, columnDefinition = "TEXT", unique = true)
     private String email;
     @Column(name = "age", updatable = true, nullable = false)
     private Integer age;
     // creating bidirectional relation user and user card
     @OneToOne(mappedBy = "user", orphanRemoval = true) // orphanRemoval = true will delete parent entity and also child
                                                        // entity, if we have it on false and we have a relation between
                                                        // entities, once we will try to remove one of them nothing will
                                                        // be deleted as hibernate will avoid delete entity that is
                                                        // currently connected to second one
     private UserCode userCode;

     // here will add one to many
     // this will make sure we have bidirectional relation from account to user and
     // back
     @OneToMany(mappedBy = "user")
     private List<Account> accounts;

     public UserCode getUserCode() {
          return userCode;
     }

     // The code `public User() {}` is a default constructor for the `User` class. A
     // constructor is a
     // special method that is used to initialize the object of a class.
     public User() {
     }

     public User(String firstName, String secondName, String email, Integer age) {
          this.firstName = firstName;
          this.secondName = secondName;
          this.email = email;
          this.age = age;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getSecondName() {
          return secondName;
     }

     public void setSecondName(String secondName) {
          this.secondName = secondName;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     @Override
     public String toString() {
          return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
                    + ", age=" + age + "]";
     }

}
