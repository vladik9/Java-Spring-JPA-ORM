package com.example.app.DrivingOrders;

import java.time.LocalDateTime;

import com.example.app.Driver.Driver;
import com.example.app.Ride.Ride;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "DrivingOrders")
@Table(name = "drivingOrders")
public class DrivingOrders {

  @EmbeddedId
  private DrivingOrdersId id;

  @ManyToOne
  @MapsId("rideId")
  @JoinColumn(name = "ride_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ride_id_fk"))
  private Ride ride;

  @ManyToOne
  @MapsId("driverId")
  @JoinColumn(name = "driver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "driver_id_fk"))
  private Driver driver;

  @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  public DrivingOrders() {
  }

  public DrivingOrders(Ride rideId, Driver driver) {
    this.ride = rideId;
    this.driver = driver;
    this.createdAt = LocalDateTime.now();
  }

  public DrivingOrders(DrivingOrdersId id, Ride rideId, Driver driver) {
    this.id = id;
    this.ride = rideId;
    this.driver = driver;
    this.createdAt = LocalDateTime.now();

  }

  /**
   * Returns the DrivingOrdersId object associated with this DrivingOrders
   * instance.
   *
   * @return the DrivingOrdersId object representing the destination order ID
   */
  public DrivingOrdersId getDestinationOrderId() {
    return id;
  }

  /**
   * Sets the destination order ID for this DrivingOrders instance.
   *
   * @param id the DrivingOrdersId object representing the destination order ID
   */
  public void setDestinationOrderId(DrivingOrdersId id) {
    this.id = id;
  }

  /**
   * Retrieves the ride associated with this DrivingOrders instance.
   *
   * @return the ride associated with this DrivingOrders instance
   */
  public Ride getRide() {
    return ride;
  }

  /**
   * Sets the ride for this DrivingOrders instance.
   *
   * @param rideId the Ride object representing the ride to set
   */
  public void setRide(Ride rideId) {
    this.ride = rideId;
  }

  /**
   * Retrieves the driver associated with this object.
   *
   * @return the driver associated with this object
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Sets the driver associated with this DrivingOrders instance.
   *
   * @param driver the Driver object representing the driver to set
   */
  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  /**
   * Retrieves the creation timestamp associated with this DrivingOrders instance.
   *
   * @return the creation timestamp associated with this DrivingOrders instance
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the creation timestamp for this object.
   *
   * @param createdAt the LocalDateTime representing the creation timestamp
   */
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Returns a string representation of the DrivingOrders object.
   *
   * @return a string representation of the DrivingOrders object
   */
  @Override
  public String toString() {
    return "Order [id=" + id + ", rideId=" + ride + ", driver=" + driver + "]";
  }

}
