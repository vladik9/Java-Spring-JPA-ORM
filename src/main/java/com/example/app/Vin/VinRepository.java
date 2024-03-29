package com.example.app.Vin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface VinRepository extends JpaRepository<Vin, Long> {
  // Vin is name of the table from ORM
  @Query("SELECT v FROM Vin v WHERE v.id = ?1")
  Vin getVin(Long vin);
}