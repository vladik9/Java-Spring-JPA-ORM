package com.example.app.UserId;

import com.example.app.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "UserId")

@Table(name = "user_id", uniqueConstraints = {
          @UniqueConstraint(name = "user_number_unique", columnNames = "id_number") })
public class UserId {
     @Id
     @SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
     @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BIGINT")
     private Long id;

     @Column(name = "id_number", length = 10, nullable = false)
     private String id_number;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "user_id", referencedColumnName = "id")
     // creating one to one relationship
     private User user;

     // The `public UserId() {}` is a default constructor for the `UserId` class.
     public UserId() {
     }

     // The `public UserId(Long id, String id_number)` is a constructor for the
     // `UserId` class that
     // takes two parameters: `id` of type `Long` and `id_number` of type `String`.
     public UserId(String id_number) {
          this.id_number = id_number;
     }

     // The `public UserId(String id_number, User user)` constructor is creating a
     // new instance of the
     // `UserId` class with the provided `id_number` and `user` parameters.
     public UserId(String id_number, User user) {
          this.id_number = id_number;
          this.user = user;
     }

     /**
      * The function returns the value of the id variable as a Long.
      * 
      * @return The method is returning a Long value.
      */
     public Long getId() {
          return id;
     }

     /**
      * The function sets the value of the "id" variable.
      * 
      * @param id The "id" parameter is of type Long, which is a wrapper class for
      *           the primitive type
      *           long. It is used to set the value of the "id" instance variable in
      *           the current object.
      */
     public void setId(Long id) {
          this.id = id;
     }

     /**
      * The function returns the value of the id_number variable.
      * 
      * @return The method is returning the value of the variable "id_number".
      */
     public String getId_number() {
          return id_number;
     }

     /**
      * The function sets the value of the id_number variable.
      * 
      * @param id_number The parameter "id_number" is a string that represents an
      *                  identification number.
      */
     public void setId_number(String id_number) {
          this.id_number = id_number;
     }

     @Override
     public String toString() {
          return "UserId [id=" + id + ", id_number=" + id_number + ", user=" + user + "]";
     }

}
