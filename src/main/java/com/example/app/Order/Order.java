package com.example.app.Order;

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

@Entity(name = "Order")
@Table(name = "order")
public class Order {

  @EmbeddedId
  private OrderId id;

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

  public Order() {
  }

  public Order(Ride rideId, Driver driver) {
    this.ride = rideId;
    this.driver = driver;
    this.createdAt = LocalDateTime.now();
  }

  public Order(OrderId id, Ride rideId, Driver driver) {
    this.id = id;
    this.ride = rideId;
    this.driver = driver;
    this.createdAt = LocalDateTime.now();

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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", rideId=" + ride + ", driver=" + driver + "]";
  }

}
