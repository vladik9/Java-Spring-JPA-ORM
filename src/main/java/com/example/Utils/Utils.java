package com.example.Utils;

import com.example.app.Car.Car;
import com.example.app.Driver.Driver;
import com.example.app.DrivingCategories.DrivingCategories;
import com.example.app.InputReader;
import com.example.app.Vin.Vin;
import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {
  // The line `public static final CarBrand[] CAR_BRANDS = CarBrand.values();` is
  // initializing an array `CAR_BRANDS` with all the values of the `CarBrand`
  // enum.
  // The `values()` method in Java enums returns an array containing all the enum
  // constants in the order they are declared. So, in this case, `CAR_BRANDS` will
  // contain all the car brands defined in the `CarBrand` enum.
  private static final CarBrand[] CAR_BRANDS = CarBrand.values();
  private static final LicenseCategory[] licenseCategory = LicenseCategory.values();
  private static final Faker faker = new Faker();
  private static final InputReader inputReader = new InputReader();
  private static Random random = new Random();

  /**
   * The function `printMenuOptions` displays a menu of options for creating,
   * retrieving, and exiting car-related tasks.
   */
  public static void printMenuOptions() {
    System.out.println("\nChoose a option your option:");
    System.out.println("From Valid options:");
    System.out.println("Option 0: Exit");
    System.out.println("####Create#####");
    System.out.println("Option 1: Create Car");
    System.out.println("Option 2: Create Driver");
    System.out.println("Option 3: Create Vin");
    System.out.println("Option 4: Create Driver Category");
    System.out.println("####Get#####");
    System.out.println("Option 5: Get Car");
    System.out.println("Option 6: Get Driver");
    System.out.println("Option 7: Get Vin");
    System.out.println("Option 8: Get Driver Category");
    System.out.println("####################\n");

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

  public static DrivingCategories generateFakeLicenseCategory() {
    Set<LicenseCategory> drivingCategories = new HashSet<>();
    for (int i = 0; i < 4; i++) {
      int index = random.nextInt(licenseCategory.length);
      drivingCategories.add(licenseCategory[index]);
    }
    return new DrivingCategories(drivingCategories);
  }
  // ##################################
  // ##################################
}
