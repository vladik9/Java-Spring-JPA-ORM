package com.example.app;

import com.example.Utils.Utils;
import com.example.app.Car.Car;
import com.example.app.Car.CarRepository;
import com.example.app.Driver.Driver;
import com.example.app.Driver.DriverRepository;
import com.example.app.Vin.Vin;
import com.example.app.Vin.VinRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;

@SpringBootApplication
public class AppApplication {

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
					// Generate X Cars
					case 1: {
						try {
							Integer amount = Integer.parseInt(inputReader.readInput("Enter amount of cars to generate: "));

						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					// Create Car, Driver and VIN
					case 2: {
						Car carOne = Utils.generateFakeCar();
						Car carTwo = Utils.generateFakeCar();
						Driver driver = Utils.generateFakeDriver();
						Vin vin = Utils.generateFakeVin();
						driver.addCar(carOne);
						driver.addCar(carTwo);

						driverRepository.save(driver);
						// FIXME: fix missing VIN on car
						// vin.setCar(carTwo);
						vinRepository.save(vin);
						break;
					}
				}
			} while (option != 0);
		};

	}
}
