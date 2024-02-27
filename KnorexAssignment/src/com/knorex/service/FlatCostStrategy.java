package com.knorex.service;

public class FlatCostStrategy implements CostStrategy {
    private static final double CAR_COST_PER_HOUR = 20.0;
    private static final double BIKE_COST_PER_HOUR = 10.0;

    @Override
    public double calculateCost(long duration) {
        return duration * CAR_COST_PER_HOUR; 
    }
}
