package com.example.design.parkinglot;

import java.util.Collections;
import java.util.List;

public class CarParkingAssistant implements ParkingAssistant {
    @Override
    public List<ParkingSpot> getParkingSport(List<ParkingSpot> availableSpots) {
        if(availableSpots.isEmpty()) {
            return Collections.emptyList();
        } else {
            return availableSpots.subList(0,1);
        }
    }
}
