package com.knorex.entity;

public class VehicleSpace {
	private int spaceNumber;
	private boolean availability;
	private VehicleType type;

	public VehicleSpace(int spaceNumber, VehicleType type) {
		this.spaceNumber = spaceNumber;
		this.availability = true;
		this.type = type;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	public boolean isAvailable() {
		return availability;
	}

	public void occupy() {
		availability = false;
	}

	public void release() {
		availability = true;
	}

	public VehicleType getType() {
		return type;
	}
}
