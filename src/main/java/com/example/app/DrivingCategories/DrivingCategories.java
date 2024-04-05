package com.example.app.DrivingCategories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.HashSet;
import java.util.Set;

import com.example.Utils.LicenseCategory;
import com.example.app.Driver.Driver;

@Entity(name = "DrivingCategories")
@Table(name = "driver_categories", uniqueConstraints = {
    @UniqueConstraint(name = "driver_categories_unique_constraint", columnNames = "id") })
public class DrivingCategories {
  @Id
  @SequenceGenerator(name = "driver_categories_sequence", sequenceName = "driver_categories_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_categories_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "driver_category_list", nullable = false, updatable = true)
  private Set<LicenseCategory> driverCategoryList;

  @ManyToMany(mappedBy = "categories")
  private Set<Driver> drivers = new HashSet<>();

  public DrivingCategories() {
  }

  public DrivingCategories(Set<LicenseCategory> driverCategoryList) {
    this.driverCategoryList = driverCategoryList;
  }

  public Set<LicenseCategory> getDriverCategory() {
    return driverCategoryList;
  }

  public void addDriverCategory(LicenseCategory driverCategoryList) {
    this.driverCategoryList.add(driverCategoryList);
  }

  public Set<Driver> getDrivers() {
    Set<Driver> drivers = this.drivers;
    return drivers;
  }

  public void addDrivers(Driver driver) {
    if (!drivers.contains(driver)) {
      drivers.add(driver);
    }
  }

  public void removeDrivers(Driver driver) {
    if (drivers.contains(driver)) {
      drivers.remove(driver);
    }
  }

  @Override
  public String toString() {
    return "DrivingCategories [driverCategory=" + driverCategoryList.toString() + "]";
  }

}
