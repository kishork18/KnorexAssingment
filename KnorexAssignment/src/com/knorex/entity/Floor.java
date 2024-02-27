package com.knorex.entity;

import java.util.List;

public class Floor {
	private int floorNumber;
	private List<VehicleSpace> vehicleSpaces;

	public Floor(int floorNumber, List<VehicleSpace> vehicleSpaces) {
		this.floorNumber = floorNumber;
		this.vehicleSpaces = vehicleSpaces;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public List<VehicleSpace> getVehicleSpaces() {
		return vehicleSpaces;
	}
}
