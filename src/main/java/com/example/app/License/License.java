package com.example.app.License;

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
import java.time.LocalDate;
import java.util.List;

import com.example.Utils.LicenseType;
import com.example.app.Driver.Driver;

@Entity(name = "License")
@Table(name = "license", uniqueConstraints = { @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class License {
  @Id
  @SequenceGenerator(name = "license_sequence", sequenceName = "license_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "license_number", nullable = false, updatable = false)
  private String licenseNumber;

  @Column(name = "issue_date", nullable = false, updatable = true)
  private LocalDate issueDate;

  @Column(name = "expiration_date", nullable = false, updatable = true)
  private LocalDate expirationDate;

  @Column(name = "licenses_list", nullable = false, updatable = true)
  private List<LicenseType> licenses_list;

  @OneToOne(mappedBy = "license", cascade = CascadeType.ALL, orphanRemoval = true)
  private Driver driver;

  public License() {

  }

  public License(String licenseNumber, LocalDate issueDate, LocalDate expirationDate, List<LicenseType> licenses_list) {
    this.licenseNumber = licenseNumber;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
    this.licenses_list = licenses_list;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  public List<LicenseType> getLicenses_list() {
    return licenses_list;
  }

  public void setLicenses_list(List<LicenseType> licenses_list) {
    this.licenses_list = licenses_list;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  @Override
  public String toString() {
    return "License [id=" + id + ", licenseNumber=" + licenseNumber + ", issueDate=" + issueDate + ", expirationDate="
        + expirationDate + ", licenses_list=" + licenses_list + ", driver=" + driver + "]";
  }

}