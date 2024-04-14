package com.example.app.Order;

import java.util.List;

import com.example.app.DestinationOrders.DestinationOrders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;

@Entity(name = "Orders")
@Table(name = "Orders", uniqueConstraints = {
    @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class Order {

  @Id
  @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "price", nullable = false, updatable = true)
  private Double price;

  @Column(name = "distance", nullable = false, updatable = true)
  private Double distance;

  public Order() {
  }

  public Order(Long id, Double price, Double distance) {
    this.id = id;
    this.price = price;
    this.distance = distance;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "order")
  private List<DestinationOrders> destinationOrders = new ArrayList<>();

  public List<DestinationOrders> getDestinationOrders() {
    return destinationOrders;
  }

  public void setDestinationOrders(List<DestinationOrders> orders) {
    this.destinationOrders = orders;
  }

  public void addOrder(DestinationOrders order) {
    if (!this.destinationOrders.contains(order))
      this.destinationOrders.add(order);
  }

  public void removeOrder(DestinationOrders order) {
    if (this.destinationOrders.contains(order))
      this.destinationOrders.remove(order);
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", price=" + price + ", distance=" + distance + "]";
  }

}
