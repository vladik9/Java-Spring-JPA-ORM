package com.example.app;

import com.example.Utils.Utils;
import com.example.app.Car.Car;
import com.example.app.Car.CarRepository;
import com.example.app.Driver.DriverRepository;
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
					case 0:
						System.exit(0);
						break;
					case 1: {
						try {
							vinRepository.save(Utils.readInputCar(inputReader));
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					case 2: {
						try {
							Integer amount = Integer.parseInt(inputReader.readInput("Enter amount of cars to generate: "));
							Faker faker = new Faker();
							String carName, carColor, VIN;
							Integer year, number_of_seats;

							for (int i = 0; i < amount; i++) {

								carName = Utils.generateFakeCarName();
								carColor = faker.color().name().toUpperCase();
								year = faker.number().numberBetween(1990, 2023 + 1);
								number_of_seats = faker.number().numberBetween(2, 4 + 1);
								VIN = faker.bothify("?????################").toUpperCase();

								// Driver driver = new Driver(faker.name().firstName(),
								// faker.number().numberBetween(18, 60 + 1),
								// faker.number().numberBetween(0, 20));

								Car car = new Car(carName, carColor, year, number_of_seats);
								Vin carVIN = new Vin(VIN, car);
								vinRepository.save(carVIN);
							}
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					case 3: {
						try {
							Long id = Long.parseLong(inputReader.readInput("Enter Car id:"));
							carRepository.findById(id)
									.ifPresentOrElse((c -> System.out.println(c)),
											() -> {
												System.out.println("Not found");
											});
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					case 4: {
						try {
							Long id = Long.parseLong(inputReader.readInput("Enter Vin id: "));
							vinRepository.findById(id).ifPresentOrElse((c -> System.out.println(c)),
									() -> {
										System.out.println("Not found");
									});
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					case 5: {
						try {
							Long id = Long.parseLong(inputReader.readInput("Enter Driver id: "));
							driverRepository.findById(id).ifPresentOrElse((c -> System.out.println(c)),
									() -> {
										System.out.println("Not found");
									});
						} catch (DataAccessException ex) {
							System.out.println(ex.getCause().getMessage());
						}
						break;
					}
					default: {
						System.out.println(option + " is not a valid option");
					}
						break;
				}
			} while (option != 0);
		};

	}

}
