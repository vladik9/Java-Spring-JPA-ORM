package com.example.app.DestinationOrders;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

// Composition Key table
@Embeddable
public class DestinationOrdersKey implements Serializable {

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "distance_id")
  private Long distanceId;

  public DestinationOrdersKey() {
  }

  public DestinationOrdersKey(Long orderId, Long distanceId) {
    this.orderId = orderId;
    this.distanceId = distanceId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getDistanceId() {
    return distanceId;
  }

  public void setDistanceId(Long distanceId) {
    this.distanceId = distanceId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
    result = prime * result + ((distanceId == null) ? 0 : distanceId.hashCode());
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
    DestinationOrdersKey other = (DestinationOrdersKey) obj;
    if (orderId == null) {
      if (other.orderId != null)
        return false;
    } else if (!orderId.equals(other.orderId))
      return false;
    if (distanceId == null) {
      if (other.distanceId != null)
        return false;
    } else if (!distanceId.equals(other.distanceId))
      return false;
    return true;
  }

}
