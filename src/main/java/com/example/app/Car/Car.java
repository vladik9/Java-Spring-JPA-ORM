package com.example.app.Car;

import com.example.app.CarVIN.CarVIN;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Column(name = "year", nullable = true, updatable = true)
    private Integer year;

    @Column(name = "number_of_seats", nullable = true, updatable = true)
    private Integer numberOfSeats;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_vin_id", referencedColumnName = "id", nullable = false, updatable = false)
    private CarVIN carVIN;

    public Car() {
    }

    public Car(String name, String color, Integer year, Integer numberOfSeats, CarVIN carVIN) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.numberOfSeats = numberOfSeats;
        this.carVIN = carVIN;
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

    public CarVIN getCarVIN() {
      return carVIN;
    }

    public void setCarVIN(CarVIN carVIN) {
      this.carVIN = carVIN;
    }

    @Override
    public String toString() {
      return "Car [id=" + id + ", name=" + name + ", color=" + color + ", year=" + year + ", numberOfSeats="
          + numberOfSeats + ", carVIN=" + carVIN + "]";
    }

       
}
