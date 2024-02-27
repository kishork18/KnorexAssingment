package com.knorex.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.knorex.entity.Vehicle;

public class VehicleDAOImpl implements VehicleDAO {
	private List<Vehicle> vehicles;

	public VehicleDAOImpl() {
		this.vehicles = new ArrayList<>();
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	@Override
	public void removeVehicle(String registrationNumber) {
		Iterator<Vehicle> iterator = vehicles.iterator();
		while (iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
				iterator.remove();
				break;
			}
		}
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicles;
	}
}
