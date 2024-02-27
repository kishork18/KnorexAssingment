package com.knorex.service;

public class BusTruckCostStrategy implements CostStrategy {
    private static final double BUS_COST_PER_HOUR = 30.0;
    private static final double TRUCK_COST_PER_HOUR = 30.0;

    @Override
    public double calculateCost(long duration) {
        return duration * BUS_COST_PER_HOUR; 
    }
}
