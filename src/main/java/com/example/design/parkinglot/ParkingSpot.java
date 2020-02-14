package com.example.design.parkinglot;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParkingSpot {
    private int level; // L1, L2, L3
    private int row; // A, B, C
    private int spot; // 1, 2 , 3
}
