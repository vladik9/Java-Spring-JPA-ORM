package com.example.app.user;

//not used yet but will be used on entity
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Entity // This tells Hibernate to make a table out of this class
public class User {
     @GetMapping("/")
     public String userFunction() {
          return "User page";
     }

     // @Id
     // @GeneratedValue(strategy = GenerationType.AUTO)
     // private Integer id;

     // private String name;

     // private String email;

     // public Integer getId() {
     // return id;
     // }

     // public void setId(Integer id) {
     // this.id = id;
     // }

     // public String getName() {
     // return name;
     // }

     // public void setName(String name) {
     // this.name = name;
     // }

     // public String getEmail() {
     // return email;
     // }

     // public void setEmail(String email) {
     // this.email = email;
     // }

}
