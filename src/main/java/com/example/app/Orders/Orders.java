package com.example.app.Orders;

import com.example.app.Driver.Driver;
import com.example.app.Ride.Ride;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "Orders")
@Table(name = "orders")
public class Orders {

  @EmbeddedId
  private OrderId id;

  @ManyToOne
  @MapsId("rideId")
  @JoinColumn(name = "ride_id")
  private Ride ride;

  @ManyToOne
  @MapsId("driverId")
  @JoinColumn(name = "driver_id")
  private Driver driver;

  public Orders() {
  }

  public Orders(Ride rideId, Driver driver) {
    this.ride = rideId;
    this.driver = driver;
  }

  public Orders(OrderId id, Ride rideId, Driver driver) {
    this.id = id;
    this.ride = rideId;
    this.driver = driver;
  }

  public OrderId getDestinationOrderId() {
    return id;
  }

  public void setDestinationOrderId(OrderId id) {
    this.id = id;
  }

  public Ride getRide() {
    return ride;
  }

  public void setRide(Ride rideId) {
    this.ride = rideId;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  @Override
  public String toString() {
    return "Orders [id=" + id + ", rideId=" + ride + ", driver=" + driver + "]";
  }

}
