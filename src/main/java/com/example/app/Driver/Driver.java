package com.example.app.Driver;

import com.example.app.Car.Car;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.HashSet;
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

  @Column(name = "yearsOfExperience", updatable = true, nullable = false)
  private Integer yearsOfExperience;
  // relation part
  // One Car has one Driver, but one Driver can have multiple Cars
  @OneToMany(mappedBy = "driver", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private Set<Car> cars = new HashSet<Car>();

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

  public Set<Car> getCars() {
    return cars;
  }

  public void setCars(Set<Car> cars) {
    this.cars = cars;
  }

  // add cars into set and set driver
  public void addCar(Car car) {
    if (!this.cars.contains(car)) {
      cars.add(car);
      car.setDriver(this);
    }
  }

  // remove car from set and set driver to null
  public void removeCar(Car car) {
    if (this.cars.contains(car)) {
      this.cars.remove(car);
      car.setDriver(null);
    }
  }

  @Override
  public String toString() {
    return "Driver [id=" + id + ", name=" + name + ", age=" + age + ", yearsOfExperience=" + yearsOfExperience
        + ", cars=" + "]";
  }

}
