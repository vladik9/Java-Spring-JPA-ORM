package com.example.app.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "Driver")
@Table(name = "driver",uniqueConstraints = {
  @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class Driver {
  @Id
  @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence")
  private Long id;
  private String name;
  private Integer age;
  private Integer experience;

  

  public Driver() {
  }
  
  public Driver(String name, Integer age, Integer experience) {
    this.name = name;
    this.age = age;
    this.experience = experience;
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
  public Integer getExperience() {
    return experience;
  }
  public void setExperience(Integer experience) {
    this.experience = experience;
  }

  // private List<Car> cars;
  
  @Override
  public String toString() {
    return "Driver [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + "]";
  }
  
}
