package com.assessment.parkinglot.spots;

import com.assessment.parkinglot.Vehicle;
import com.assessment.parkinglot.enums.SpotSize;

public class SpotFactory {

    public static ParkingSpot getParkingSpot(Vehicle vehicle, SpotSize spotSize){

        switch (spotSize){
            case SMALL: return new SmallParkingSpot(vehicle,spotSize);
            case MEDIUM: return new MediumParkingSpot(vehicle, spotSize);
            case LARGE: return new LargeParkingSpot(vehicle,spotSize);
            default: return new SmallParkingSpot(vehicle,spotSize);
        }
    }
}
