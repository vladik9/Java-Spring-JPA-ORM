package com.example.app.Ride;

import jakarta.persistence.ForeignKey;
import java.util.List;

import com.example.app.Destination.Destination;
import com.example.app.DrivingOrders.DrivingOrders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;

@Entity(name = "Ride")
@Table(name = "ride", uniqueConstraints = {
    @UniqueConstraint(name = "ride_unique_constraint", columnNames = "id")
})
public class Ride {

  @Id
  @SequenceGenerator(name = "ride_sequence", sequenceName = "ride_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ride_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "price", nullable = false, updatable = true, columnDefinition = "DECIMAL")
  private Double price;

  @Column(name = "distance", nullable = false, updatable = true, columnDefinition = "DECIMAL")
  private Double distance;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "destination_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "destination_id_fk"))
  private Destination destination;

  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "ride")
  private List<DrivingOrders> ordersList = new ArrayList<>();

  public Ride() {
  }

  public Ride(Double price, Double distance, Destination destination) {

    this.price = price;
    this.distance = distance;
    this.destination = destination;
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

  public List<DrivingOrders> getOrdersList() {
    return ordersList;
  }

  public void setOrdersList(List<DrivingOrders> orders) {
    this.ordersList = orders;
  }

  public void addOrder(DrivingOrders order) {
    if (!this.ordersList.contains(order))
      this.ordersList.add(order);
  }

  public void removeOrder(DrivingOrders order) {
    if (this.ordersList.contains(order))
      this.ordersList.remove(order);
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  @Override
  public String toString() {
    return "Ride [id=" + id + ", price=" + price + ", distance=" + distance + ", destination=" + destination
        + ", ordersList=" + ordersList + "]";
  }

}
