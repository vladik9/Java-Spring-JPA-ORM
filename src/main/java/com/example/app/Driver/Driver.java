package com.example.app.Driver;

import jakarta.persistence.ForeignKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.example.app.Car.Car;
import com.example.app.License.License;
import com.example.app.Order.Order;
import com.example.app.Passenger.Passenger;
import com.example.app.Ride.Ride;

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
import jakarta.persistence.OneToOne;
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

  @Column(name = "name", nullable = false, updatable = true, columnDefinition = "TEXT")
  private String name;

  @Column(name = "age", updatable = true, nullable = false, columnDefinition = "INT")
  private Integer age;

  @Column(name = "experience", updatable = true, nullable = false, columnDefinition = "INT")
  private Integer experience;

  @Column(name = "driven_cars_number", updatable = true, nullable = false, columnDefinition = "INT")
  private Integer drivenCarsNumber;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "license_id_fk"))
  private License license;

  @OneToMany(mappedBy = "driver", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<Passenger> passengers = new ArrayList<>();

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  @JoinTable(name = "drivenCarList", joinColumns = @JoinColumn(name = "driver_id"), foreignKey = @ForeignKey(name = "driver_list_id_fk"), inverseJoinColumns = @JoinColumn(name = "car_id"))
  private Set<Car> drivenCarsList = new HashSet<>();

  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "driver")
  private List<Order> ordersList = new ArrayList<>();

  public Driver() {
  }

  public Driver(String driverName, Integer age, Integer drivingExperience) {
    this.name = driverName;
    this.age = age;
    this.experience = drivingExperience;
    this.drivenCarsNumber = 0;
  }

  public String getName() {
    return name;
  }

  public void setName(String driverName) {
    this.name = driverName;
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

  public void setExperience(Integer drivingExperience) {
    this.experience = drivingExperience;
  }

  public void addPassengers(Passenger passenger) {
    if (!this.passengers.contains(passenger)) {
      this.passengers.add(passenger);
      passenger.setDriver(this);
    }

  }

  // opposite here, removing cars from driver and set driver to null
  public void removePassenger(Passenger passenger) {
    if (this.passengers.contains(passenger)) {
      this.passengers.remove(passenger);
      passenger.setDriver(null);
    }
  }

  public Passenger getPassenger(Integer index) {
    if (index < 0 || index >= this.passengers.size()) {
      return null;
    }
    Passenger passenger = this.passengers.get(index);
    return passenger;

  }

  public List<Passenger> getPassengers() {
    return this.passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public Integer getDrivenCarsNumber() {
    return drivenCarsNumber;
  }

  public void setDrivenCarsNumber(Integer carsIsDriving) {
    this.drivenCarsNumber = carsIsDriving;
  }

  public License getLicense() {
    return license;
  }

  public void setLicense(License license) {
    this.license = license;
  }

  public Set<Car> getCarsList() {
    return drivenCarsList;
  }

  public void setCarList(Set<Car> cars) {
    this.drivenCarsList = cars;
    this.drivenCarsNumber = cars.size();
  }

  public void addCarsToDrivenList(Car car) {
    if (!drivenCarsList.contains(car)) {
      drivenCarsList.add(car);
      car.getDrivers().add(this);
      this.drivenCarsNumber++;
    }
  }

  public void removeCarsToDrivenList(Car car) {
    if (drivenCarsList.contains(car)) {
      drivenCarsList.remove(car);
      car.getDrivers().remove(this);
      this.drivenCarsNumber--;
    }
  }

  public List<Order> getOrdersList() {
    return ordersList;
  }

  public void setOrdersList(List<Order> ordersList) {
    this.ordersList = ordersList;
  }

  public void addOrder(Order order) {
    if (!this.ordersList.contains(order))
      this.ordersList.add(order);
  }

  public void removeOrder(Order order) {
    if (this.ordersList.contains(order))
      this.ordersList.remove(order);
  }

  @Override
  public String toString() {
    return "Driver [id=" + id + ", driverName=" + name + ", age=" + age + ", drivingExperience="
        + experience + "]";
  }

}
