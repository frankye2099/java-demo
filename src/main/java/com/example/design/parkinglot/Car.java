package com.example.design.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Car extends Vehicle {
    @Builder.Default
    private VehicleType type = VehicleType.CAR;
    @Builder.Default
    private int needSpots = 1;
}
