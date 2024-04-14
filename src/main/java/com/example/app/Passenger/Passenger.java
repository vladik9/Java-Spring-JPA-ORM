package com.example.app.Passenger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import com.example.app.Driver.Driver;

@Entity(name = "Passenger")
@Table(name = "passenger", uniqueConstraints = {
    @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class Passenger {
  @Id
  @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, updatable = true, columnDefinition = "TEXT")
  private String name;

  @Column(name = "age", nullable = false, updatable = true, columnDefinition = "INT")
  private Integer age;

  @Column(name = "gender", nullable = false, updatable = true, columnDefinition = "TEXT")
  private String gender;

  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private Driver driver;

  public Passenger() {
  }

  public Passenger(String name, Integer age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  @Override
  public String toString() {
    return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", driver=" + driver
        + "]";
  }

}
