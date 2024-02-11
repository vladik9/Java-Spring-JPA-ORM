package com.example.app.account;

import com.example.app.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Account")
@Table(name = "account", uniqueConstraints = {
          @UniqueConstraint(name = "account_unique_constraint", columnNames = "account_id") })

public class Account {

     @Id
     @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
     @Column(name = "account_id", updatable = false, nullable = false, columnDefinition = "BIGINT")
     private Long id;

     @Column(name = "created_date", nullable = false)
     private String created_date;
     @Column(name = "account_amount", nullable = false)
     private Long account_amount;
     @ManyToOne
     @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_id_fk"))
     private User user;

     public Account() {
     }

     public Account(String created_date, Long account_amount, User user) {
          this.created_date = created_date;
          this.account_amount = account_amount;
          this.user = user;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getCreated_date() {
          return created_date;
     }

     public void setCreated_date(String created_date) {
          this.created_date = created_date;
     }

     public Long getAccount_amount() {
          return account_amount;
     }

     public void setAccount_amount(Long account_amount) {
          this.account_amount = account_amount;
     }

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     @Override
     public String toString() {
          return "Account [id=" + id + ", created_date=" + created_date + ", account_amount=" + account_amount
                    + ", user=" + user + "]";
     }

}
