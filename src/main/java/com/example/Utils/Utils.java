package com.example.Utils;

import com.example.app.Car.Car;
import com.example.app.Car.CarRepository;
import com.example.app.Driver.Driver;
import com.example.app.Driver.DriverRepository;
import com.example.app.InputReader;
import com.example.app.Vin.Vin;
import com.example.app.Vin.VinRepository;
import com.github.javafaker.Faker;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Utils {
  // The line `public static final CarBrand[] CAR_BRANDS = CarBrand.values();` is
  // initializing an array `CAR_BRANDS` with all the values of the `CarBrand`
  // enum.
  // The `values()` method in Java enums returns an array containing all the enum
  // constants in the order they are declared. So, in this case, `CAR_BRANDS` will
  // contain all the car brands defined in the `CarBrand` enum.
  public static final CarBrand[] CAR_BRANDS = CarBrand.values();
  public static final Faker faker = new Faker();
  public static final InputReader inputReader = new InputReader();

  /**
   * The function `printMenuOptions` displays a menu of options for creating,
   * retrieving, and exiting car-related tasks.
   */
  public static void printMenuOptions() {
    System.out.println("\nChoose a option your option:");
    System.out.println("From Valid options:");
    System.out.println("Option 0: Exit\n");
    System.out.println("Option 1: Create and save a new x amount of cars(automated), including VIN");
    System.out.println("Option 2: Create and save a Car a Driver and a VIN\n");

  }

  /**
   * The function generates a fake car name by randomly selecting a car brand from
   * a
   * predefined list.
   * 
   * @return The method `generateFakeCarName()` returns a randomly selected car
   *         brand
   *         from the `CAR_BRANDS` array in the `Utils` class.
   */
  public static String generateFakeCarName() {
    Random random = new Random();
    int index = random.nextInt(Utils.CAR_BRANDS.length);
    return Utils.CAR_BRANDS[index].toString();
  }

  // ##################################
  // generator of Cars, Drivers and Vin's
  public static Car generateFakeCar() {
    return new Car(Utils.generateFakeCarName(), faker.color().name().toUpperCase(),
        faker.number().numberBetween(1990, 2023 + 1), faker.number().numberBetween(2, 4 + 1));
  }

  public static Driver generateFakeDriver() {
    return new Driver(faker.name().fullName(), faker.number().numberBetween(18, 60),
        faker.number().numberBetween(2, 10));
  }

  public static Vin generateFakeVin() {
    return new Vin(faker.bothify("?????################").toUpperCase());
  }
  // ##################################
}
