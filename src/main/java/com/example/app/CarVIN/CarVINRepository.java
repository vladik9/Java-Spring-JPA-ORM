package com.example.app.CarVIN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CarVINRepository extends JpaRepository<CarVIN, Long> {
  // VIN is name of the table from ORM
  @Query("SELECT v FROM VIN v WHERE v.id = ?1")
  CarVIN getByCarVIN(Long carVIN);
}