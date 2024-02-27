package com.knorex.dao;

import java.util.List;

import com.knorex.entity.Floor;

public class FloorDAOImpl implements FloorDAO {

	private List<Floor> floors;

	public FloorDAOImpl(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public List<Floor> getAllFloors() {
		return floors;
	}

	@Override
	public void updateAllFloors(List<Floor> updatedFloors) {
		this.floors = updatedFloors;
	}

}
