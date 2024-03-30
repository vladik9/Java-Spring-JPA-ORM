package com.example.Utils;

import com.example.app.Car.Car;
import com.example.app.Driver.Driver;
import com.example.app.InputReader;
import com.example.app.Vin.Vin;
import com.github.javafaker.Faker;
import java.util.Random;

public class Utils {
  // The line `public static final CarBrand[] CAR_BRANDS = CarBrand.values();` is
  // initializing an array `CAR_BRANDS` with all the values of the `CarBrand`
  // enum.
  // The `values()` method in Java enums returns an array containing all the enum
  // constants in the order they are declared. So, in this case, `CAR_BRANDS` will
  // contain all the car brands defined in the `CarBrand` enum.
  public static final CarBrand[] CAR_BRANDS = CarBrand.values();

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

  /**
   * The function `readInputCar` reads input from the user to create a new Car
   * object with a randomly generated VIN.
   * 
   * @param inputInputReader The `inputInputReader` parameter in the
   *                         `readInputCar`
   *                         method is an object of type `InputReader`. It is used
   *                         to read input from the
   *                         user for various attributes of a car such as name,
   *                         color, year, and number of
   *                         seats. The `readInput` method of the
   * @return An instance of the `Car` class is being returned, which is created
   *         based on the input provided by the user through the `InputReader` and
   *         Faker
   *         library. The `Car` object includes attributes such as name, color,
   *         year,
   *         number of seats, and a randomly generated VIN (Vehicle Identification
   *         Number).
   */
  public static Vin readInputCar(InputReader inputInputReader) {
    Faker faker = new Faker();
    String name, color;
    Integer year, number_of_seats;
    name = inputInputReader.readInput("Enter car name: ");
    color = inputInputReader.readInput("Enter car color:");
    year = Integer.parseInt(inputInputReader.readInput("Enter car year: "));
    number_of_seats = Integer.parseInt(inputInputReader.readInput("Enter car number of seats: "));
    String VIN = faker.bothify("?????################").toUpperCase();
    // Driver driver = new Driver();
    Car car = new Car(name, color, year, number_of_seats);
    Vin carVIN = new Vin(VIN, car);

    return carVIN;
  }

  /**
   * The function `printMenuOptions` displays a menu of options for creating,
   * retrieving, and exiting car-related tasks.
   */
  public static void printMenuOptions() {
    System.out.println("\nChoose a option your option:");
    System.out.println("From Valid options:");
    System.out.println("Option 1: Create and save a new car");
    System.out.println("Option 2: Create and save a new x amount of cars(automated)");
    System.out.println("Option 3: Get a car by Car Id");
    System.out.println("Option 4: Get a Car VIN Id");
    System.out.println("Option 5: Get Driver by id:");
    System.out.println("Option 0: Exit\n");
  }

}
