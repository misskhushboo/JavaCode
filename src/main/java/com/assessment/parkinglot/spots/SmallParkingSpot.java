package com.assessment.parkinglot.spots;

import com.assessment.parkinglot.Vehicle;
import com.assessment.parkinglot.enums.SpotSize;

import java.util.UUID;

public class SmallParkingSpot extends ParkingSpot{

    public SmallParkingSpot(Vehicle vehicle, SpotSize spotSize) {
        super(vehicle, spotSize);
    }
}
