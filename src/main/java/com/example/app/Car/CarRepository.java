package com.example.app.Car;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// we can extend 
// JpaRepository, JPA methods, flush and batch
// PagingAndSortingRepository, paginating and sorting 
// CrudRepository, crud functions
//  JpaRepository -> PagingAndSortingRepository -> CrudRepository
public interface CarRepository extends JpaRepository<Car, Long> {

  @Query("SELECT c FROM Car c WHERE c.name = ?1")
  List<Car> getCarByName(String name);

}