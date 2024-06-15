package com.example.app.DrivingOrders;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// Composition Key table
@Embeddable
public class DrivingOrdersId implements Serializable {

  @Column(name = "ride_id")
  private Long rideId;

  @Column(name = "driver_id")
  private Long driverId;

  public DrivingOrdersId() {
  }

  public DrivingOrdersId(Long rideId, Long driverId) {
    this.rideId = rideId;
    this.driverId = driverId;
  }

  /**
   * Retrieves the ride ID associated with this DrivingOrdersId object.
   *
   * @return the ride ID as a Long
   */
  public Long getRideId() {
    return rideId;
  }

  /**
   * Sets the ride ID for this DrivingOrdersId object.
   *
   * @param orderId the new ride ID to set
   */
  public void setRideId(Long orderId) {
    this.rideId = orderId;
  }

  /**
   * Retrieves the driver ID associated with this DrivingOrdersId object.
   *
   * @return the driver ID as a Long
   */
  public Long getDriverId() {
    return driverId;
  }

  /**
   * Sets the driver ID for this DrivingOrdersId object.
   *
   * @param driverId the new driver ID to set
   */
  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  /**
   * Calculates the hash code for this DrivingOrdersId object.
   *
   * @return the hash code value for this DrivingOrdersId object
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rideId == null) ? 0 : rideId.hashCode());
    result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
    return result;
  }

  /**
   * Determines whether this DrivingOrdersId object is equal to another object.
   *
   * @param obj the object to compare to this object
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DrivingOrdersId other = (DrivingOrdersId) obj;
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
