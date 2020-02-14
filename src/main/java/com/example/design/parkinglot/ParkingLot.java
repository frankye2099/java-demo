package com.example.design.parkinglot;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ParkingLot {
    private int gate;
    private int levels;
    private int rows;
    private int spots;

    @Singular
    private List<Gate> gates;
    @Singular
    private List<ParkingSpot> availableSpots;
    @Singular
    private List<Vehicle> vehicles;
    @Singular
    private List<Vehicle> arrivals;

}
