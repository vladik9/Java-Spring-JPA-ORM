package com.example.app.Driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.app.Car.Car;
import com.example.app.DrivingOrders.DrivingOrders;
import com.example.app.License.License;
import com.example.app.Passenger.Passenger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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
  private List<DrivingOrders> ordersList = new ArrayList<>();

  public Driver() {
  }

  public Driver(String driverName, Integer age, Integer drivingExperience) {
    this.name = driverName;
    this.age = age;
    this.experience = drivingExperience;
    this.drivenCarsNumber = 0;
  }

  /**
   * Returns the name of the object.
   *
   * @return the name of the object as a String
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the driver.
   *
   * @param driverName the new name of the driver
   */
  public void setName(String driverName) {
    this.name = driverName;
  }

  /**
   * Returns the age of the object.
   *
   * @return the age of the object as an Integer
   */
  public Integer getAge() {
    return age;
  }

  /**
   * Sets the age of the driver.
   *
   * @param age the new age of the driver as an Integer
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * Returns the experience of the driver.
   *
   * @return the experience of the driver as an Integer
   */
  public Integer getExperience() {
    return experience;
  }

  /**
   * Sets the driving experience of the driver.
   *
   * @param drivingExperience the new driving experience of the driver
   */
  public void setExperience(Integer drivingExperience) {
    this.experience = drivingExperience;
  }

  /**
   * Adds a passenger to the list of passengers if they are not already in the
   * list.
   *
   * @param passenger the passenger to be added
   */
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

  /**
   * Removes a passenger from the list of passengers if they are present.
   *
   * @param passenger the passenger to be removed
   */
  public Passenger getPassenger(Integer index) {
    if (index < 0 || index >= this.passengers.size()) {
      return null;
    }
    Passenger passenger = this.passengers.get(index);
    return passenger;

  }

  /**
   * Returns the list of passengers associated with this driver.
   *
   * @return the list of passengers
   */
  public List<Passenger> getPassengers() {
    return this.passengers;
  }

  /**
   * Sets the list of passengers associated with this driver.
   *
   * @param passengers the list of passengers to be set
   */
  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  /**
   * Returns the number of cars that this driver is currently driving.
   *
   * @return the number of driven cars as an Integer
   */
  public Integer getDrivenCarsNumber() {
    return drivenCarsNumber;
  }

  /**
   * Sets the number of cars that this driver is currently driving.
   *
   * @param carsIsDriving the number of driven cars to be set
   */
  public void setDrivenCarsNumber(Integer carsIsDriving) {
    this.drivenCarsNumber = carsIsDriving;
  }

  /**
   * Retrieves the License object associated with this Driver.
   *
   * @return the License object associated with this Driver
   */
  public License getLicense() {
    return license;
  }

  /**
   * Sets the License object associated with this Driver.
   *
   * @param license the License object to be set
   */
  public void setLicense(License license) {
    this.license = license;
  }

  /**
   * Retrieves the list of cars that this driver is currently driving.
   *
   * @return the set of cars driven by this driver
   */
  public Set<Car> getCarsList() {
    return drivenCarsList;
  }

  /**
   * Sets the list of cars that this driver is currently driving.
   *
   * @param cars the set of cars to be set
   */
  public void setCarList(Set<Car> cars) {
    this.drivenCarsList = cars;
    this.drivenCarsNumber = cars.size();
  }

  /**
   * Adds a car to the list of cars that this driver is currently driving.
   *
   * @param car the car to be added to the list
   */
  public void addCarsToDrivenList(Car car) {
    if (!drivenCarsList.contains(car)) {
      drivenCarsList.add(car);
      car.getDrivers().add(this);
      this.drivenCarsNumber++;
    }
  }

  /**
   * Removes a car from the list of cars that this driver is currently driving.
   *
   * @param car the car to be removed from the list
   */
  public void removeCarsToDrivenList(Car car) {
    if (drivenCarsList.contains(car)) {
      drivenCarsList.remove(car);
      car.getDrivers().remove(this);
      this.drivenCarsNumber--;
    }
  }

  /**
   * Returns the list of DrivingOrders associated with this Driver.
   *
   * @return the list of DrivingOrders
   */
  public List<DrivingOrders> getOrdersList() {
    return ordersList;
  }

  /**
   * Sets the list of DrivingOrders associated with this Driver.
   *
   * @param ordersList the list of DrivingOrders to be set
   */
  public void setOrdersList(List<DrivingOrders> ordersList) {
    this.ordersList = ordersList;
  }

  /**
   * Adds a DrivingOrders object to the ordersList if it is not already present.
   *
   * @param order the DrivingOrders object to be added
   */
  public void addOrder(DrivingOrders order) {
    if (!this.ordersList.contains(order))
      this.ordersList.add(order);
  }

  /**
   * Removes a specific DrivingOrders object from the ordersList.
   *
   * @param order the DrivingOrders object to be removed
   */
  public void removeOrder(DrivingOrders order) {
    if (this.ordersList.contains(order))
      this.ordersList.remove(order);
  }

  /**
   * Returns a string representation of the Driver object.
   *
   * @return a string representation of the Driver object, including the id, name,
   *         age, and driving experience.
   */
  @Override
  public String toString() {
    return "Driver [id=" + id + ", driverName=" + name + ", age=" + age + ", drivingExperience="
        + experience + "]";
  }

}
