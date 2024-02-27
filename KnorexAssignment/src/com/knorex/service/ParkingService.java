package com.knorex.service;

import java.util.ArrayList;
import java.util.List;

import com.knorex.dao.FloorDAO;
import com.knorex.dao.VehicleDAO;
import com.knorex.entity.Floor;
import com.knorex.entity.Vehicle;
import com.knorex.entity.VehicleSpace;
import com.knorex.entity.VehicleType;

public class ParkingService {
    private VehicleDAO vehicleDAO;
    private FloorDAO floorDAO;

    public ParkingService(VehicleDAO vehicleDAO, FloorDAO floorDAO) {
        this.vehicleDAO = vehicleDAO;
        this.floorDAO = floorDAO;
    }

    public String addVehicle(Vehicle vehicle) {
        List<Floor> floors = floorDAO.getAllFloors();
        for (Floor floor : floors) {
            List<VehicleSpace> spaces = floor.getVehicleSpaces();
            for (VehicleSpace space : spaces) {
                if (space.isAvailable() && space.getType() == vehicle.getType()) {
                    space.occupy();
                    vehicleDAO.addVehicle(vehicle);
                    return "Vehicle added successfully" ; 
                }
            }
        }
        return  "No available space found for the vehicle";
    }
    public void initializeParkingLot(int numFloors, int numSpacesPerFloor) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            List<VehicleSpace> vehicleSpaces = new ArrayList<>();
            for (int j = 1; j <= numSpacesPerFloor; j++) {
                vehicleSpaces.add(new VehicleSpace(j, VehicleType.CAR)); 
                vehicleSpaces.add(new VehicleSpace(j, VehicleType.BUS)); 
                vehicleSpaces.add(new VehicleSpace(j, VehicleType.TRUCK)); 
                vehicleSpaces.add(new VehicleSpace(j, VehicleType.BIKE)); 
            }
            Floor floor = new Floor(i, vehicleSpaces);
            floors.add(floor);
        }
        floorDAO.updateAllFloors(floors);
    }

    public String removeVehicle(String registrationNumber) {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                List<Floor> floors = floorDAO.getAllFloors();
                for (Floor floor : floors) {
                    List<VehicleSpace> spaces = floor.getVehicleSpaces();
                    for (VehicleSpace space : spaces) {
                        if (!space.isAvailable() && space.getType() == vehicle.getType()) {
                            space.release();
                            vehicleDAO.removeVehicle(registrationNumber);
                            return   "Vehicle removed successfully";
                        }
                    }
                }
            }
        }
        return "Vehicle not found or not parked";
    }

    public boolean checkAvailability(int floorNumber) {
        List<Floor> floors = floorDAO.getAllFloors();
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                List<VehicleSpace> spaces = floor.getVehicleSpaces();
                for (VehicleSpace space : spaces) {
                    if (space.isAvailable()) {
                        System.out.println("Floor " + floorNumber + " has available space for vehicle.");
                        return true;
                    }
                }
            }
        }
        System.out.println("Floor " + floorNumber + " is full.");
        return false;
    }

    public double calculateCost(VehicleType type, long duration) {
        CostStrategy strategy = getCostStrategy(type);
        if (strategy != null) {
            return strategy.calculateCost(duration);
        } else {
            System.out.println("No cost strategy found for vehicle type: " + type);
            return 0;
        }
    }

    private CostStrategy getCostStrategy(VehicleType type) {
        switch (type) {
            case CAR:
            case BIKE:
                return new FlatCostStrategy(); 
            case BUS:
            case TRUCK:
                return new BusTruckCostStrategy(); 
            default:
                return null;
        }
    }
   
}
