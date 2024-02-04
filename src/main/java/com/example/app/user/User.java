package com.example.app.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
//jakarta app
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@RestController
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

     // The code `public User() {}` is a default constructor for the `User` class. A
     // constructor is a
     // special method that is used to initialize the object of a class.
     public User() {
     }

     // The code you provided is a constructor for the `User` class. A constructor is
     // a special method
     // that is used to initialize the object of a class.
     public User(String firstName, String secondName, String email, Integer age) {
          this.firstName = firstName;
          this.secondName = secondName;
          this.email = email;
          this.age = age;
     }

     // The code you provided is defining getter and setter methods for the fields in
     // the `User` class.
     public Long getId() {
          return id;
     }

     /**
      * The function sets the value of the "id" variable.
      * 
      * @param id The "id" parameter is an Integer type, which is used to set the
      *           value of the "id"
      *           variable in the class.
      */
     public void setId(Long id) {
          this.id = id;
     }

     /**
      * The function returns the value of the variable "firstName".
      * 
      * @return The method is returning the value of the variable "firstName".
      */
     public String getFirstName() {
          return firstName;
     }

     /**
      * The function sets the value of the "firstName" variable.
      * 
      * @param firstName The parameter "firstName" is a String that represents the
      *                  first name of a
      *                  person.
      */
     // The code you provided is defining getter and setter methods for the fields in
     // the `User` class.
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     /**
      * The function "getSecondName" returns the value of the variable
      * "secondName".
      * 
      * @return The method is returning the value of the variable "secondName".
      */

     /**
      * The function returns the value of the secondName variable.
      * 
      * @return The method is returning the value of the variable "secondName".
      */
     public String getSecondName() {
          return secondName;
     }

     /**
      * The function sets the value of the secondName variable.
      * 
      * @param secondName The parameter "secondName" is a String that represents
      *                   the second name of a
      *                   person.
      */
     /**
      * The function sets the value of the secondName variable.
      * 
      * @param secondName The parameter "secondName" is a String that represents
      *                   the second name of a
      *                   methods for the `email` field in the `User`
      *                   person.
      */
     public void setSecondName(String secondName) {
          this.secondName = secondName;
     }

     /**
      * The getEmail() function returns the email address.
      * 
      * @return The email value is being returned.
      */
     /**
      * The getEmail() function returns the email address.
      * 
      * @return The email value is being returned.
      */
     public String getEmail() {
          return email;
     }

     /**
      * The function sets the email property of an object to the provided email
      * value.
      * 
      * @param email The email parameter is a string that represents an email
      *              address.
      */
     public void setEmail(String email) {
          this.email = email;
     }

     /**
      * The function "getAge" returns the age as an Integer.
      * 
      * @return The method is returning an Integer value, which is the age.
      */
     public Integer getAge() {
          return age;
     }

     /**
      * The function sets the age of an object.
      * 
      * @param age The "age" parameter is an Integer that represents the age of an
      *            object or entity.
      */
     public void setAge(Integer age) {
          this.age = age;
     }

     /**
      * The toString() function returns a string representation of a User object.
      * 
      * @return The toString() method is returning a string representation of a User
      *         object. The string
      *         includes the values of the id, firstName, secondName, email, and
      *         age properties of the User
      *         object.
      */
     @Override
     public String toString() {
          return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
                    + ", age=" + age + "]";
     }

}
