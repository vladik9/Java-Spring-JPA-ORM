package com.example.app.DestinationOrders;

import com.example.app.Destination.Destination;
import com.example.app.Order.Order;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "DestinationOrders")
@Table(name = "destinationOrders")
public class DestinationOrders {

  @EmbeddedId
  private DestinationOrdersKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @OneToMany
  @MapsId("distanceId")
  @JoinColumn(name = "distance_id")
  private Destination destination;

  public DestinationOrders() {
  }

  public DestinationOrders(Order order, Destination destination) {
    this.order = order;
    this.destination = destination;
  }

  public DestinationOrdersKey getDestinationOrderId() {
    return id;
  }

  public void setDestinationOrderId(DestinationOrdersKey id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

}
