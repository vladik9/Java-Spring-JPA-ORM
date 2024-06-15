package com.example.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.app.InputReader;
import com.example.app.Car.Car;
import com.example.app.Destination.Destination;
import com.example.app.Driver.Driver;
import com.example.app.License.License;
import com.example.app.Passenger.Passenger;
import com.example.app.Ride.Ride;
import com.example.app.Vin.Vin;
import com.github.javafaker.Faker;

public class Utils {
  // The line `public static final CarBrand[] CAR_BRANDS = CarBrand.values();` is
  // initializing an array `CAR_BRANDS` with all the values of the `CarBrand`
  // enum.
  // The `values()` method in Java enums returns an array containing all the enum
  // constants in the order they are declared. So, in this case, `CAR_BRANDS` will
  // contain all the car brands defined in the `CarBrand` enum.
  private static final CarBrandEnum[] CAR_BRANDS = CarBrandEnum.values();
  private static final LicenseEnum[] licenseTypes = LicenseEnum.values();
  private static final GendersEnum[] genders = GendersEnum.values();
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
    System.out.println("Option 1: Create one Entity");
    System.out.println("Option 2: Create X Entities");
    System.out.println("Option 3: Create Order and Driver");
    // System.out.println("Option 2: Create Driver");
    // System.out.println("Option 3: Create Vin");
    // System.out.println("Option 4: Create Driver Category");
    // System.out.println("####Get#####");
    // System.out.println("Option 5: Get Car");
    // System.out.println("Option 6: Get Driver");
    // System.out.println("Option 7: Get Vin");
    // System.out.println("Option 8: Get Driver Category");
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
  public static String generateCarName() {
    int index = random.nextInt(Utils.CAR_BRANDS.length);
    return Utils.CAR_BRANDS[index].toString();
  }

  /**
   * Generates a list of random LicenseEnum objects representing different driving
   * categories.
   *
   * @return a list of LicenseEnum objects representing driving categories
   */
  public static List<LicenseEnum> generateLicenseCategory() {
    List<LicenseEnum> drivingCategories = new ArrayList<LicenseEnum>();
    for (int i = 0; i < 4; i++) {
      int index = random.nextInt(licenseTypes.length);
      drivingCategories.add(licenseTypes[index]);
    }
    return drivingCategories;
  }

  // ##################################
  // generator of Cars, Drivers and Vin's
  /**
   * Generates a new Car object with randomly generated car name, color, year, and
   * number of doors.
   *
   * @return a new Car object with randomly generated attributes
   */
  public static Car generateCar() {
    return new Car(Utils.generateCarName(), faker.color().name().toUpperCase(),
        faker.number().numberBetween(1990, 2023 + 1), faker.number().numberBetween(2, 4 + 1));
  }

  /**
   * Generates a new Driver object with random name, age, and number of cars
   * owned.
   *
   * @return a new Driver object with random name, age, and number of cars owned
   */
  public static Driver generateDriver() {
    return new Driver(faker.name().fullName(), faker.number().numberBetween(18, 60),
        faker.number().numberBetween(2, 10));
  }

  /**
   * Generates a new Vin object with a randomly generated VIN number.
   *
   * @return a new Vin object with a randomly generated VIN number
   */
  public static Vin generateVin() {
    return new Vin(faker.bothify("?????################").toUpperCase());
  }

  /**
   * Generates a new License object with a randomly generated license number,
   * the current date, a date 10 years from now, and a randomly generated
   * license category.
   *
   * @return a new License object with a randomly generated license number,
   *         the current date, a date 10 years from now, and a randomly
   *         generated license category.
   */
  public static License generateLicenses() {
    return new License(faker.bothify("################"), LocalDate.now(),
        LocalDate.now().plusYears(10), generateLicenseCategory());
  }

  /**
   * Generates a new Passenger object with random name, age, and gender.
   *
   * @return a new Passenger object with random name, age, and gender
   */
  public static Passenger generatePassenger() {
    return new Passenger(
        faker.name().fullName(),
        faker.number().numberBetween(18, 60),
        genders[faker.random().nextInt(genders.length)].toString());
  }

  /**
   * Generates a new Ride object with a randomly generated price, distance, and
   * destination.
   *
   * @return a new Ride object with a randomly generated price, distance, and
   *         destination
   */
  public static Ride generateRide() {
    double distance = faker.number().randomDouble(2, 0, 100);
    double price = distance * 1.5;
    return new Ride(price, distance, generateDestination());
  }

  /**
   * Generates a new Destination object with randomly generated longitude and
   * latitude values.
   *
   * @return A new Destination object with randomly generated longitude and
   *         latitude values.
   */
  public static Destination generateDestination() {
    return new Destination(faker.address().longitude(), faker.address().latitude());

  }
  // ##################################
  // ##################################
}
