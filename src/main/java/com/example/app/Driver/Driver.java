package com.example.app.Driver;

import jakarta.persistence.ForeignKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.app.Car.Car;
import com.example.app.DrivingCategories.DrivingCategories;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

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

  @Column(name = "name", nullable = false, updatable = true)
  private String driverName;

  @Column(name = "age", updatable = true, nullable = false)
  private Integer age;

  @Column(name = "drivingExperience", updatable = true, nullable = false)
  private Integer drivingExperience;
  @Column(name = "number_of_drove_cars", updatable = true, nullable = false)
  private Integer numberOfDroveCars;

  @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Car> cars = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "driver_category_list", joinColumns = @JoinColumn(name = "driver_id"), foreignKey = @ForeignKey(name = "driver_categories_fk"), inverseJoinColumns = @JoinColumn(name = "driver_categories_id"))
  private Set<DrivingCategories> categories = new HashSet<>();

  public Driver() {
  }

  public Driver(String driverName, Integer age, Integer drivingExperience) {
    this.driverName = driverName;
    this.age = age;
    this.drivingExperience = drivingExperience;
    this.numberOfDroveCars = 0;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getDrivingExperience() {
    return drivingExperience;
  }

  public void setDrivingExperience(Integer drivingExperience) {
    this.drivingExperience = drivingExperience;
  }

  public void addCar(Car car) {
    if (!cars.contains(car)) {
      this.cars.add(car);
    }

  }

  public Car getCar(Integer index) {
    if (index < 0 || index >= this.cars.size()) {
      return null;
    }
    Car car = this.cars.get(index);
    return car;

  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public Set<DrivingCategories> getCategories() {
    return categories;
  }

  public void addCategories(DrivingCategories categoryToAdd) {
    this.categories.add(categoryToAdd);
  }

  public Integer getNumberOfDroveCars() {
    return numberOfDroveCars;
  }

  public void setNumberOfDroveCars(Integer carsIsDriving) {
    this.numberOfDroveCars = carsIsDriving;
  }

  @Override
  public String toString() {
    return "Driver [id=" + id + ", driverName=" + driverName + ", age=" + age + ", drivingExperience="
        + drivingExperience + "]";
  }

}
