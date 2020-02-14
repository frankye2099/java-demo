package com.example.design.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Bus extends Vehicle {
    @Builder.Default
    private VehicleType type = VehicleType.BUS;
    @Builder.Default
    private int needSpots = 3;
}
