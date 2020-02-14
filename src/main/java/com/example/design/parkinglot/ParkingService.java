package com.example.design.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingService {

    public void initParkingLot(ParkingLot parkingLot) {
        IntStream.rangeClosed(1,parkingLot.getGate())
                .mapToObj(x -> Gate.builder().gateNumber("G" + x).build())
                .forEach(gate -> parkingLot.getGates().add(gate));

        IntStream.rangeClosed(1, parkingLot.getLevels()).forEach(l ->
                IntStream.rangeClosed(1, parkingLot.getRows()).forEach(r ->
                        IntStream.rangeClosed(1, parkingLot.getSpots()).forEach(s ->
                                parkingLot.getAvailableSpots().add(ParkingSpot.builder().level(l).row(r).spot(s).build()))));
    }

    public synchronized List<ParkingSpot> getParkingSpotsFor(ParkingLot parkingLot, VehicleType type) {
        ParkingAssistant assistant = ParkingAssistantFactory.getParkingAssistant(type);
        return assistant.getParkingSport(parkingLot.getAvailableSpots());
    }

    public synchronized void leaveParkingSpots(ParkingLot parkingLot, List<ParkingSpot> parkingLots) {
        parkingLot.getAvailableSpots().addAll(parkingLots);
        parkingLot.getAvailableSpots().sort(Comparator.comparing(ParkingSpot::getLevel)
                .thenComparing(ParkingSpot::getRow)
                .thenComparing(ParkingSpot::getSpot)
        );
    }

    public void arrival(Vehicle vehicle) {

    }
}
