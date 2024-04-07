package com.example.app.Car;

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
import java.util.HashSet;
import java.util.Set;

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

  @Column(name = "number_of_seats", nullable = true, updatable = true)
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

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String model) {
    this.brand = model;
  }

  public void setVin(Vin vin) {
    this.vin = vin;
  }

  public Set<Driver> getDrivers() {
    return drivers;
  }

  public void setDrivers(Set<Driver> drivers) {
    this.drivers = drivers;
  }

  public void addDriver(Driver driver) {
    this.drivers.add(driver);
  }

  public void removeDriver(Driver driver) {
    this.drivers.remove(driver);
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", model=" + brand + ", color=" + color + ", year=" + year + ", numberOfSeats="
        + numberOfSeats + ", vin=" + vin + "]";
  }

}