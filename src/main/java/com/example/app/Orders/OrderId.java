package com.example.app.Orders;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

// Composition Key table
@Embeddable
public class OrderId implements Serializable {

  @Column(name = "ride_id")
  private Long rideId;

  @Column(name = "driver_id")
  private Long driverId;

  public OrderId() {
  }

  public OrderId(Long rideId, Long driverId) {
    this.rideId = rideId;
    this.driverId = driverId;
  }

  public Long getRideId() {
    return rideId;
  }

  public void setRideId(Long orderId) {
    this.rideId = orderId;
  }

  public Long getDriverId() {
    return driverId;
  }

  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rideId == null) ? 0 : rideId.hashCode());
    result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderId other = (OrderId) obj;
    if (rideId == null) {
      if (other.rideId != null)
        return false;
    } else if (!rideId.equals(other.rideId))
      return false;
    if (driverId == null) {
      if (other.driverId != null)
        return false;
    } else if (!driverId.equals(other.driverId))
      return false;
    return true;
  }

}
