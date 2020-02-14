package com.example.design.parkinglot;

public class ParkingAssistantFactory {
    public static ParkingAssistant getParkingAssistant(VehicleType type) {
        switch (type) {
            case BUS:
                return new BusParkingAssistant();
            default:
                return new CarParkingAssistant();
        }
    }
}
