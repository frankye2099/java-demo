package com.example.design.parkinglot;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Vehicle {
    private VehicleType type;
    private String plate;
    private int needSpots;
    private ParkingSpot[] parkingSpots;
}
