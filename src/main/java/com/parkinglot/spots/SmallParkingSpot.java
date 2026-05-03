package com.parkinglot.spots;

import com.parkinglot.Vehicle;
import com.parkinglot.enums.SpotSize;

public class SmallParkingSpot extends ParkingSpot{

    public SmallParkingSpot(Vehicle vehicle, SpotSize spotSize) {
        super(vehicle, spotSize);
    }
}
