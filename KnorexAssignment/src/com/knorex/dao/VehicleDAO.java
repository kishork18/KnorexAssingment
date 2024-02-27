package com.knorex.dao;

import java.util.List;

import com.knorex.entity.Vehicle;

public interface VehicleDAO {
	void addVehicle(Vehicle vehicle);

	void removeVehicle(String registrationNumber);

	List<Vehicle> getAllVehicles();
}
