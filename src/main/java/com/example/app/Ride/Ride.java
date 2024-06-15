package com.example.app.Ride;

import java.util.ArrayList;
import java.util.List;

import com.example.app.Destination.Destination;
import com.example.app.DrivingOrders.DrivingOrders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

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

  /**
   * Get the price of the ride.
   *
   * @return the price of the ride
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Sets the price of the ride.
   *
   * @param price The new price of the ride.
   */
  public void setPrice(Double price) {
    this.price = price;
  }

  /**
   * Returns the distance of the ride.
   *
   * @return the distance of the ride
   */
  public Double getDistance() {
    return distance;
  }

  /**
   * Sets the distance of the ride.
   *
   * @param distance The new distance of the ride.
   */
  public void setDistance(Double distance) {
    this.distance = distance;
  }

  /**
   * Retrieves the list of DrivingOrders associated with this Ride.
   *
   * @return a list of DrivingOrders
   */
  public List<DrivingOrders> getOrdersList() {
    return ordersList;
  }

  /**
   * Sets the list of DrivingOrders associated with this Ride.
   *
   * @param orders the list of DrivingOrders to be set
   */
  public void setOrdersList(List<DrivingOrders> orders) {
    this.ordersList = orders;
  }

  /**
   * Adds a DrivingOrders object to the ordersList if it is not already present.
   *
   * @param order the DrivingOrders object to be added
   * @return
   */
  public void addOrder(DrivingOrders order) {
    if (!this.ordersList.contains(order))
      this.ordersList.add(order);
  }

  /**
   * Removes a specific DrivingOrders object from the ordersList.
   *
   * @param order the DrivingOrders object to be removed
   */
  public void removeOrder(DrivingOrders order) {
    if (this.ordersList.contains(order))
      this.ordersList.remove(order);
  }

  /**
   * Returns the destination of the ride.
   *
   * @return the destination of the ride
   */
  public Destination getDestination() {
    return destination;
  }

  /**
   * Sets the destination of the ride.
   *
   * @param destination the new destination to set for the ride
   */
  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  /**
   * Returns a string representation of the Ride object.
   *
   * @return a string representation of the Ride object, including the id, price,
   *         distance, destination, and ordersList.
   */
  @Override
  public String toString() {
    return "Ride [id=" + id + ", price=" + price + ", distance=" + distance + ", destination=" + destination
        + ", ordersList=" + ordersList + "]";
  }

}
