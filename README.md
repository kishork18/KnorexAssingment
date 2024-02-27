# Car Parking System

This project implements a car parking system in Java that supports different types of vehicles and configurable cost strategies. The system allows users to initialize the parking lot, add vehicles, remove vehicles, check availability, and calculate parking fees.

## Project Structure

The project consists of the following components:

1. **Entity Layer**: Contains classes representing entities like Vehicle, Floor, and VehicleSpace.
2. **DAO Layer**: Provides interfaces and implementations for data access operations.
3. **Service Layer**: Implements the core business logic for the parking system.
4. **Presentation Layer**: Contains the main class for user interaction and input handling.

## Usage

1. **Initialization**: The parking lot can be initialized with the desired number of floors and vehicle spaces per floor using the `initializeParkingLot` method in the `ParkingService` class.

2. **Adding Vehicles**: Vehicles can be added to the parking lot using the `addVehicle` method in the `ParkingService` class. Users need to provide the registration number, color, and type of the vehicle.

3. **Removing Vehicles**: Vehicles can be removed from the parking lot using the `removeVehicle` method in the `ParkingService` class. Users need to provide the registration number of the vehicle to be removed.

4. **Checking Availability**: Users can check the availability of vehicle spaces on a specific floor using the `checkAvailability` method in the `ParkingService` class. Users need to provide the floor number.

5. **Calculating Cost**: The parking fee for a vehicle can be calculated using the `calculateCost` method in the `ParkingService` class. Users need to provide the type of vehicle and the duration of parking.

## Additional Notes

- The project uses a layered architecture with separate layers for entity, DAO, service, and presentation.
- Different cost strategies are implemented for calculating parking fees based on the type of vehicle.
- User interaction is handled in the main class (`Main`) in the presentation layer.

## Dependencies

- Java 8 or higher

## How to Run

To run the project, compile all Java files and execute the `Main` class.
