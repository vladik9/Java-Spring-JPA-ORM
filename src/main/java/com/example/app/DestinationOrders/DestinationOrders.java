package com.example.app.DestinationOrders;

import com.example.app.Destination.Destination;
import com.example.app.Order.Order;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "DestinationOrders")
@Table(name = "destinationOrders")
public class DestinationOrders {

  @EmbeddedId
  private DestinationOrdersComKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @MapsId("destinationId")
  @JoinColumn(name = "destination_id")
  private Destination destination;

  public DestinationOrders() {
  }

  public DestinationOrders(Order order, Destination destination) {
    this.order = order;
    this.destination = destination;
  }

  public DestinationOrders(DestinationOrdersComKey id, Order order, Destination destination) {
    this.id = id;
    this.order = order;
    this.destination = destination;
  }

  public DestinationOrdersComKey getDestinationOrderId() {
    return id;
  }

  public void setDestinationOrderId(DestinationOrdersComKey id) {
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

  @Override
  public String toString() {
    return "DestinationOrders [id=" + id + ", order=" + order + ", destination=" + destination + "]";
  }

}
