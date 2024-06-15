package com.example.app.Destination;

import com.example.app.Ride.Ride;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Destination")
@Table(name = "destination", uniqueConstraints = {
    @UniqueConstraint(name = "destination_unique_constraint", columnNames = "id") })
public class Destination {

  @Id
  @SequenceGenerator(name = "destination_sequence", sequenceName = "destination_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "destination_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "longitude", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String longitude;

  @Column(name = "latitude", nullable = true, updatable = true, columnDefinition = "TEXT")
  private String latitude;

  @OneToOne(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
  private Ride ride;

  public Destination() {
  }

  public Destination(String longitude, String latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  /**
   * Retrieves the ID of the Destination object.
   *
   * @return the ID of the Destination object as a Long
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the Destination object.
   *
   * @param id the new ID to set for the Destination object
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Retrieves the longitude of the Destination object.
   *
   * @return the longitude of the Destination object as a String
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets the longitude of the Destination object.
   *
   * @param longitude the new longitude to set for the Destination object
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * Retrieves the latitude of the Destination object.
   *
   * @return the latitude of the Destination object as a String
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Sets the latitude of the Destination object.
   *
   * @param latitude the new latitude to set for the Destination object
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Retrieves the ride associated with this Destination object.
   *
   * @return the ride associated with this Destination object
   */
  public Ride getRide() {
    return ride;
  }

  /**
   * Sets the ride for this Destination object.
   *
   * @param ride the new ride to set for this Destination object
   */
  public void setRide(Ride ride) {
    this.ride = ride;
  }

  /**
   * Returns a string representation of the Destination object.
   *
   * @return a string representation of the Destination object
   */
  @Override
  public String toString() {
    return "Destination [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", ride=" + ride + "]";
  }

}
