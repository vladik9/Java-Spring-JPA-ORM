package com.example.app.UserCode;

import com.example.app.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "UserCode")

@Table(name = "user_code", uniqueConstraints = {
          @UniqueConstraint(name = "user_code_unique", columnNames = "code_number") })
public class UserCode {
     @Id
     @SequenceGenerator(name = "user_code_sequence", sequenceName = "user_code_sequence", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_code_sequence")
     @Column(name = "user_code", updatable = false, nullable = false, columnDefinition = "BIGINT")
     private Long user_code;

     @Column(name = "code_number", length = 10, nullable = false)
     private String code_number;

     @OneToOne(cascade = CascadeType.ALL) // fetch = FetchType.EAGER
     // ?FetchType Eager, means that once user code is
     // fetched the user will be also added and populated(default)
     // With lazy this is not happening

     @JoinColumn(name = "id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_id_code_fk"))
     // creating one to one relationship
     // one user can have one user code
     private User user;

     public UserCode() {
     }

     public UserCode(String code_number) {
          this.code_number = code_number;
     }

     public UserCode(String code_number, User user) {
          this.code_number = code_number;
          this.user = user;
     }

     public Long getUser_code() {
          return user_code;
     }

     public void setUser_code(Long code) {
          this.user_code = code;
     }

     public String getCode_number() {
          return code_number;
     }

     public void setCode_number(String id_number) {
          this.code_number = id_number;
     }

     @Override
     public String toString() {
          return "UserCode [id= " + user_code + ", code_number= " + code_number + ", user= " + user + "]";
     }

}
