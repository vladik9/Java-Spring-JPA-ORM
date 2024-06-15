package com.example.app.Car;

import java.util.HashSet;
import java.util.Set;

import com.example.app.Driver.Driver;
import com.example.app.Vin.Vin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Car")
@Table(name = "car", uniqueConstraints = {
    @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class Car {

  @Id
  @SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "model", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String brand;

  @Column(name = "color", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String color;

  @Column(name = "year", nullable = true, updatable = true, columnDefinition = "INT")
  private Integer year;

  @Column(name = "number_of_seats", nullable = true, updatable = true, columnDefinition = "INT")
  private Integer numberOfSeats;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "vin_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "car_vin_fk"))
  private Vin vin;

  @ManyToMany(mappedBy = "drivenCarsList", cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE })
  private Set<Driver> drivers = new HashSet<>();

  public Car() {

  }

  public Car(String model, String color, Integer year, Integer numberOfSeats) {
    this.brand = model;
    this.color = color;
    this.year = year;
    this.numberOfSeats = numberOfSeats;
  }

  /**
   * Retrieves the color of the car.
   *
   * @return the color of the car as a string
   */
  public String getColor() {
    return color;
  }

  /**
   * Sets the color of the object.
   *
   * @param color the new color to set
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Returns the year of the object.
   *
   * @return the year as an Integer
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Sets the year of the object.
   *
   * @param year the new year to set
   */
  public void setYear(Integer year) {
    this.year = year;
  }

  /**
   * Retrieves the number of seats in the car.
   *
   * @return the number of seats as an Integer
   */
  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

  /**
   * Sets the number of seats for the car.
   *
   * @param numberOfSeats the new number of seats for the car
   */
  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  /**
   * Returns the brand of the object.
   *
   * @return the brand as a string
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Sets the brand of the object.
   *
   * @param model the new brand for the object
   */
  public void setBrand(String model) {
    this.brand = model;
  }

  /**
   * Sets the Vin (Vehicle Identification Number) for this car.
   *
   * @param vin the new Vin for this car
   */
  public void setVin(Vin vin) {
    this.vin = vin;
  }

  /**
   * Returns the set of drivers associated with this car.
   *
   * @return a set of Driver objects representing the drivers associated with this
   *         car
   */
  public Set<Driver> getDrivers() {
    return drivers;
  }

  /**
   * Sets the set of drivers associated with this car.
   *
   * @param drivers a set of Driver objects representing the drivers associated
   *                with this car
   */
  public void setDrivers(Set<Driver> drivers) {
    this.drivers = drivers;
  }

  /**
   * Adds a driver to the set of drivers associated with this car.
   *
   * @param driver the driver to be added
   */
  public void addDriver(Driver driver) {
    this.drivers.add(driver);
  }

  /**
   * Removes a driver from the set of drivers associated with this car.
   *
   * @param driver the driver to be removed
   */
  public void removeDriver(Driver driver) {
    this.drivers.remove(driver);
  }

  /**
   * Returns a string representation of the Car object.
   *
   * @return a string in the format "Car [id=<id>, model=<brand>, color=<color>,
   *         year=<year>, numberOfSeats=<numberOfSeats>, vin=<vin>]"
   */
  @Override
  public String toString() {
    return "Car [id=" + id + ", model=" + brand + ", color=" + color + ", year=" + year + ", numberOfSeats="
        + numberOfSeats + ", vin=" + vin + "]";
  }

}