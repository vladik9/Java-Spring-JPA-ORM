package com.example.app.DestinationOrders;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

// Composition Key table
@Embeddable
public class DestinationOrdersComKey implements Serializable {

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "destination_id")
  private Long destinationId;

  public DestinationOrdersComKey() {
  }

  public DestinationOrdersComKey(Long orderId, Long distanceId) {
    this.orderId = orderId;
    this.destinationId = distanceId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getDestinationId() {
    return destinationId;
  }

  public void setDestinationId(Long distanceId) {
    this.destinationId = distanceId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
    result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
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
    DestinationOrdersComKey other = (DestinationOrdersComKey) obj;
    if (orderId == null) {
      if (other.orderId != null)
        return false;
    } else if (!orderId.equals(other.orderId))
      return false;
    if (destinationId == null) {
      if (other.destinationId != null)
        return false;
    } else if (!destinationId.equals(other.destinationId))
      return false;
    return true;
  }

}
