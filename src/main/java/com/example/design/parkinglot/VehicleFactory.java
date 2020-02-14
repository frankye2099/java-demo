package com.example.design.parkinglot;

import java.util.Random;
import java.util.UUID;

public class VehicleFactory {
    public static Vehicle random() {
        int i = new Random().nextInt(100);
        if(i < 10) {
            return Bus.builder().plate(UUID.randomUUID().toString()).build();
        } else {
            return Car.builder().plate(UUID.randomUUID().toString()).build();
        }
    }
}
