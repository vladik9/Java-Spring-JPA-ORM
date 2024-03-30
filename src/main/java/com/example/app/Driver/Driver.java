package com.example.app.Driver;

import com.example.app.Car.Car;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Set;

@Entity(name = "Driver")
@Table(name = "driver", uniqueConstraints = {
    @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class Driver {
  @Id
  @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name", updatable = true, nullable = false)
  private String name;

  @Column(name = "age", updatable = true, nullable = false)
  private Integer age;

  @Column(name = "experience", updatable = true, nullable = false)
  private Integer yearsOfExperience;
  // here
  // @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch =
  // FetchType.EAGER)
  // private Set<Car> cars;

  public Driver() {
  }

  public Driver(String name, Integer age, Integer yearsOfExperience) {
    this.name = name;
    this.age = age;
    this.yearsOfExperience = yearsOfExperience;
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
    return yearsOfExperience;
  }

  public void setExperience(Integer yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public Integer getYearsOfExperience() {
    return yearsOfExperience;
  }

  public void setYearsOfExperience(Integer yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  @Override
  public String toString() {
    return "Driver [id=" + id + ", name=" + name + ", age=" + age + ", yearsOfExperience=" + yearsOfExperience
        + ", cars=" + "]";
  }

}
