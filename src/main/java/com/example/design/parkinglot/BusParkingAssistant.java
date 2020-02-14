package com.example.design.parkinglot;

import java.util.Collections;
import java.util.List;

public class BusParkingAssistant implements ParkingAssistant {
    @Override
    public List<ParkingSpot> getParkingSport(List<ParkingSpot> availableSpots) {
        if(availableSpots.size() >= 3) {
            for (int i = 0; i < availableSpots.size(); i++) {
                if(isNext(availableSpots.get(i), availableSpots.get(i+1))
                        && isNext(availableSpots.get(i+1), availableSpots.get(i+2))) {
                    return availableSpots.subList(i, i+3);
                }
            }
        }
        return Collections.emptyList();
    }

    private boolean isNext(ParkingSpot spot1, ParkingSpot spot2) {
        return spot1.getLevel() == spot2.getLevel()
                && spot1.getRow() == spot2.getRow()
                && spot1.getSpot() + 1 == spot2.getSpot();
    }
}
