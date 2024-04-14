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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public Ride getRide() {
    return ride;
  }

  public void setOrder(Ride ride) {
    this.ride = ride;
  }

  @Override
  public String toString() {
    return "Destination [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", ride=" + ride + "]";
  }

}
