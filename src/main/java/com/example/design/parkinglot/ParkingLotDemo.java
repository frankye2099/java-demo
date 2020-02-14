package com.example.design.parkinglot;

import java.util.Random;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.builder().gate(4).levels(3).rows(5).spots(6).build();
        ParkingService parkingService = new ParkingService();

        parkingService.initParkingLot(parkingLot);

        new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
                parkingService.arrival(VehicleFactory.random());
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
