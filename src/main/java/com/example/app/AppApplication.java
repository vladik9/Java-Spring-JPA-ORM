package com.example.app;

import com.example.Utils.Utils;
import com.example.app.Car.CarRepository;
import com.example.app.Car.Car;
import com.example.app.Driver.Driver;
import com.example.app.Driver.DriverRepository;
import com.example.app.License.License;
import com.example.app.Orders.Orders;
import com.example.app.Orders.OrderId;
import com.example.app.Passenger.Passenger;
import com.example.app.Ride.Ride;
import com.example.app.Vin.Vin;
import com.example.app.Vin.VinRepository;
import com.github.javafaker.Faker;

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
			VinRepository vinRepository, DriverRepository driverRepository) {
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
					// Option 1: Create Entity
					case 1: {
						try {
							Car car = Utils.generateCar();
							Vin vin = Utils.generateVin();
							Driver driver = Utils.generateDriver();
							Passenger passenger = Utils.generatePassenger();
							License license = Utils.generateLicenses();

							car.setVin(vin);
							driver.addCarsToDrivenList(car);
							driver.setLicense(license);
							driver.addCarsToDrivenList(car);
							driver.addPassengers(passenger);

							carRepository.save(car);

							System.out.println("Car: " + car + " Vin: " + vin + " Driver: " + driver + " Passenger "
									+ passenger + " Licenses" + license);

						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					case 2: {
						try {
							System.out.println("Enter amount of entities to generate:");
							Integer amount = Integer.parseInt(inputReader.readInput());
							for (int i = 0; i < amount; i++) {
								Car car = Utils.generateCar();
								Vin vin = Utils.generateVin();
								Driver driver = Utils.generateDriver();
								Passenger passenger = Utils.generatePassenger();
								License license = Utils.generateLicenses();

								car.setVin(vin);
								driver.addCarsToDrivenList(car);
								driver.setLicense(license);
								driver.addCarsToDrivenList(car);
								driver.addPassengers(passenger);

								carRepository.save(car);

								System.out.println("Car: " + car + " Vin: " + vin + " Driver: " + driver + " Passenger "
										+ passenger + " Licenses" + license);
							}
						} catch (Exception ex) {
							System.out.println(ex.getCause().getMessage());

						}
						break;
					}
					case 3: {
						Ride order = Utils.generateOrder();
						Driver driver = Utils.generateDriver();
						License license = Utils.generateLicenses();
						driver.setLicense(license);
						System.out.println(order + " " + driver);
						driver.addOrder(new Orders(new OrderId(1L, 1L), order, driver));
						driverRepository.save(driver);
						try {
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());

						}
						break;
					}
				}
			} while (option != 0);
		};

	}
}
