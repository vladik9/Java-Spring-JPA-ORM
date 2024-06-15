package com.example.app.License;

import java.time.LocalDate;
import java.util.List;

import com.example.Utils.LicenseEnum;
import com.example.app.Driver.Driver;

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

@Entity(name = "License")
@Table(name = "license", uniqueConstraints = { @UniqueConstraint(name = "car_unique_constraint", columnNames = "id")
})
public class License {
  @Id
  @SequenceGenerator(name = "license_sequence", sequenceName = "license_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "license_number", nullable = false, updatable = false, columnDefinition = "TEXT")
  private String licenseNumber;

  @Column(name = "issue_date", nullable = false, updatable = true)
  private LocalDate issueDate;

  @Column(name = "expiration_date", nullable = false, updatable = true)
  private LocalDate expirationDate;

  @Column(name = "licenses_list", nullable = false, updatable = true)
  private List<LicenseEnum> licenses_list;

  @OneToOne(mappedBy = "license", cascade = CascadeType.ALL, orphanRemoval = true)
  private Driver driver;

  public License() {

  }

  public License(String licenseNumber, LocalDate issueDate, LocalDate expirationDate, List<LicenseEnum> licenses_list) {
    this.licenseNumber = licenseNumber;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
    this.licenses_list = licenses_list;
  }

  /**
   * Retrieves the ID of the License object.
   *
   * @return the ID of the License object as a Long
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the object.
   *
   * @param id the new ID to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Returns the license number of this object.
   *
   * @return the license number as a String
   */
  public String getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * Sets the license number of this object.
   *
   * @param licenseNumber the new license number to set
   */
  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  /**
   * Returns the issue date of this object.
   *
   * @return the issue date as a LocalDate
   */
  public LocalDate getIssueDate() {
    return issueDate;
  }

  /**
   * Sets the issue date of this object.
   *
   * @param issueDate the new issue date to set
   */
  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  /**
   * Retrieves the expiration date of this object.
   *
   * @return the expiration date as a LocalDate
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  /**
   * Sets the expiration date of this object.
   *
   * @param expirationDate the new expiration date to set
   */
  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the list of licenses associated with this object.
   *
   * @return a List of LicenseEnum objects representing the licenses
   */
  public List<LicenseEnum> getLicenses_list() {
    return licenses_list;
  }

  /**
   * Sets the list of licenses associated with this object.
   *
   * @param licenses_list a List of LicenseEnum objects representing the licenses
   */
  public void setLicenses_list(List<LicenseEnum> licenses_list) {
    this.licenses_list = licenses_list;
  }

  /**
   * Retrieves the driver associated with this License object.
   *
   * @return the Driver object representing the driver
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Sets the driver associated with this object.
   *
   * @param driver the Driver object representing the driver to set
   */
  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  /**
   * Returns a string representation of the License object.
   *
   * @return a string representation of the License object
   */
  @Override
  public String toString() {
    return "License [id=" + id + ", licenseNumber=" + licenseNumber + ", issueDate=" + issueDate + ", expirationDate="
        + expirationDate + ", licenses_list=" + licenses_list + ", driver=" + driver + "]";
  }

}