package com.example.app.Car;

import com.example.app.Driver.Driver;
import com.example.app.Vin.Vin;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

  @Column(name = "name", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String name;

  @Column(name = "color", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String color;

  @Column(name = "year", nullable = true, updatable = true, columnDefinition = "INT")
  private Integer year;

  @Column(name = "number_of_seats", nullable = true, updatable = true)
  private Integer numberOfSeats;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
  private Vin vin;

  // here
  // @ManyToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "driver_id", referencedColumnName = "id")
  // private Driver driver;

  public Car() {
  }

  public Car(String name, String color, Integer year, Integer numberOfSeats) {
    this.name = name;
    this.color = color;
    this.year = year;
    this.numberOfSeats = numberOfSeats;

  }

  public Vin getVin() {
    return vin;
  }

  public void setVin(Vin vin) {
    this.vin = vin;
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

  public Vin getCarVIN() {
    return vin;
  }

  public void setCarVIN(Vin vin) {
    this.vin = vin;
  }

  @Override
  public String toString() {
    return "Car [name=" + name + ", color=" + color + ", year=" + year + ", numberOfSeats=" + numberOfSeats + "]";
  }

}