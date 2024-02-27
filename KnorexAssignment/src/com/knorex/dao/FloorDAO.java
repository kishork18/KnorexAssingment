package com.knorex.dao;

import java.util.List;

import com.knorex.entity.Floor;

public interface FloorDAO {
	List<Floor> getAllFloors();

	public void updateAllFloors(List<Floor> updatedFloors);
}
