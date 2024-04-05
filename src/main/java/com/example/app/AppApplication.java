package com.example.app;

import com.example.Utils.LicenseCategory;
import com.example.Utils.Utils;
import com.example.app.Car.CarRepository;
import com.example.app.Car.Car;
import com.example.app.Driver.Driver;
import com.example.app.Driver.DriverRepository;
import com.example.app.DrivingCategories.DrivingCategories;
import com.example.app.DrivingCategories.DrivingCategoriesRepository;
import com.example.app.Vin.Vin;
import com.example.app.Vin.VinRepository;
import com.github.javafaker.Faker;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
public class AppApplication {
	public static final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	// this will run after app starts and will run a cmd line runner that will
	// create a user and add it in DB, need to mark as bea as this will be used by
	// Hibernate to identify it
	@Bean
	CommandLineRunner commandLineRunner(CarRepository carRepository, InputReader inputReader,
			VinRepository vinRepository, DriverRepository driverRepository,
			DrivingCategoriesRepository drivingCategoriesRepository) {
		return args -> {
			int option = 0;
			do {
				Utils.printMenuOptions();
				option = Integer.parseInt(inputReader.readInput());
				System.out.println("You choose: " + option);

				switch (option) {
					// System exit
					case 0:
						System.exit(0);
						break;
					// Option 1: Create Car
					case 1: {
						try {
							Car car = Utils.generateFakeCar();
							Vin vin = Utils.generateFakeVin();
							Driver driver = Utils.generateFakeDriver();
							car.setVin(vin);
							car.setDriver(driver);
							carRepository.save(car);
							System.out.println("Car: " + car + " Vin: " + vin + " Driver: " + driver);

						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					// Option 2: Create Driver
					case 2: {
						Driver driver = Utils.generateFakeDriver();
						List<Car> cars = new ArrayList<>();

						driverRepository.save(driver);
						DrivingCategories drivingCategories = Utils.generateFakeLicenseCategory();
						drivingCategoriesRepository.save(drivingCategories);

						for (int i = 0; i < new Random().nextInt(); i++) {
							Car car = Utils.generateFakeCar();
							Vin vin = Utils.generateFakeVin();

							car.setDriver(driver);
							car.setVin(vin);
							cars.add(car);
							System.out.println("Car: " + car + " Vin: " + vin + " Driver: " + driver);

						}

						driver.addCategories(drivingCategories);
						driver.setCars(cars);
						driver.setNumberOfDroveCars(cars.size());
						driverRepository.save(driver);
						break;
					}
					// Option 3: Create Vin
					case 3: {
						Vin vin = Utils.generateFakeVin();
						System.out.println(vin);
						vinRepository.save(vin);
						break;
					}
					// Option 4: Create Driver Category
					case 4: {
						DrivingCategories drivingCategories = Utils.generateFakeLicenseCategory();
						System.out.println(drivingCategories);
						drivingCategoriesRepository.save(drivingCategories);
						break;
					}
					// Option 5: Get Car
					case 5: {
						System.out.println("Enter car id");
						long carId = Long.parseLong(inputReader.readInput());
						carRepository.findById(carId).ifPresentOrElse(System.out::println,
								() -> System.out.println("Car not found"));
						break;

					}
					// Option 6: Get Driver
					case 6: {
						System.out.println("Enter Driver id");
						long driverId = Long.parseLong(inputReader.readInput());
						driverRepository.findById(driverId).ifPresentOrElse(System.out::println,
								() -> System.out.println("Driver not found"));
						break;
					}
					// Option 7: Get Vin
					case 7: {
						System.out.println("Enter Vin id");
						long vinId = Long.parseLong(inputReader.readInput());
						vinRepository.findById(vinId).ifPresentOrElse(System.out::println,
								() -> System.out.println("Vin not found"));
						break;
					}
					// Option 8: Get Driver Category
					case 8: {
						System.out.println("Enter Driver Category id:");
						long driverCategoryId = Long.parseLong(inputReader.readInput());
						drivingCategoriesRepository.findById(driverCategoryId).ifPresentOrElse(System.out::println,
								() -> System.out.println("Driver Category not found"));
						break;
					}
				}
			} while (option != 0);
		};

	}
}
