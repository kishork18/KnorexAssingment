package com.knorex.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.knorex.dao.FloorDAO;
import com.knorex.dao.FloorDAOImpl;
import com.knorex.dao.VehicleDAO;
import com.knorex.dao.VehicleDAOImpl;
import com.knorex.entity.Vehicle;
import com.knorex.entity.VehicleType;
import com.knorex.service.ParkingService;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Parking Lot System!");
		VehicleDAO vehicleDAO = new VehicleDAOImpl();
		FloorDAO floorDAO = new FloorDAOImpl(new ArrayList<>());
		ParkingService parkingService = new ParkingService(vehicleDAO, floorDAO);
		parkingService.initializeParkingLot(3, 10);
		// User interaction loop
		while (true) {
			System.out.println("1. Add Vehicle");
			System.out.println("2. Remove Vehicle");
			System.out.println("3. Check Availability");
			System.out.println("4. Calculate Cost");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter registration number: ");
				String regNumber = scanner.nextLine();
				System.out.print("Enter color: ");
				String color = scanner.nextLine();
				System.out.print("Enter vehicle type (CAR/BUS/TRUCK/BIKE): ");
				VehicleType type = VehicleType.valueOf(scanner.nextLine().toUpperCase());
				Vehicle vehicle = new Vehicle(regNumber, color, type);
				System.out.println(parkingService.addVehicle(vehicle));
				break;
			case 2:
				System.out.print("Enter registration number to remove: ");
				String regNumToRemove = scanner.nextLine();

				System.out.println(parkingService.removeVehicle(regNumToRemove));
				break;
			case 3:
				System.out.print("Enter floor number to check availability: ");
				int floorNumber = scanner.nextInt();
				parkingService.checkAvailability(floorNumber);
				break;
			case 4:
				System.out.print("Enter vehicle type (CAR/BUS/TRUCK/BIKE): ");
				VehicleType vehicleType = VehicleType.valueOf(scanner.nextLine().toUpperCase());
				System.out.print("Enter parking duration (in hours): ");
				long duration = scanner.nextLong();
				double cost = parkingService.calculateCost(vehicleType, duration);
				System.out.println("Parking fee: " + cost);
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
