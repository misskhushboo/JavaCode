package com.assessment.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int totalParkingLevels;
    Map<Integer, ParkingLevel> levels;

    ParkingLot(int parkingLevels, int spotPerLevel){
        this.totalParkingLevels = parkingLevels;
        levels= new HashMap<>();
    }

}
