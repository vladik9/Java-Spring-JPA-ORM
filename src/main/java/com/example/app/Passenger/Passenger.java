package com.example.app.Passenger;

import com.example.app.Driver.Driver;

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

  /**
   * Retrieves the ID of the passenger.
   *
   * @return the ID of the passenger as a Long
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the passenger.
   *
   * @param id the new ID to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Retrieves the name of the object.
   *
   * @return the name of the object as a String
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the passenger.
   *
   * @param name the new name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the age of the object.
   *
   * @return the age of the object as an Integer
   */
  public Integer getAge() {
    return age;
  }

  /**
   * Sets the age of the object.
   *
   * @param age the new age to set
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * Retrieves the gender of the object.
   *
   * @return the gender of the object as a String
   */
  public String getGender() {
    return gender;
  }

  /**
   * Retrieves the driver associated with this object.
   *
   * @return the Driver object representing the driver
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Sets the gender of the passenger.
   *
   * @param gender the new gender of the passenger
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Sets the driver associated with this passenger.
   *
   * @param driver the Driver object representing the driver to set
   */
  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  /**
   * Returns a string representation of the Passenger object.
   *
   * @return a string representation of the Passenger object, including the id,
   *         name, age, gender, and driver.
   */
  @Override
  public String toString() {
    return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", driver=" + driver
        + "]";
  }

}
