package com.assessment.parkinglot;

import com.assessment.parkinglot.enums.SpotSize;
import com.assessment.parkinglot.enums.VehicleType;
import com.assessment.parkinglot.spots.ParkingSpot;
import com.assessment.parkinglot.spots.SpotFactory;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Parking level having spots based on spot size
 * and vehicle type. Parking levels actually do the spot finding work.
 */
@Data
public class ParkingLevel {

    int parkingLevelId;
    int totalAvailableSpots;
    ParkingSpot parkingSpot;
    Map<SpotSize, Integer> spotCount;
    Map<SpotSize, List<ParkingSpot>> parkingSpots;

    public ParkingLevel(int totalSpots) {
        this.totalAvailableSpots = totalSpots;
        spotCount=new ConcurrentHashMap<>(totalSpots);
        parkingSpots=new ConcurrentHashMap<>(totalSpots);
        spotCount.put(SpotSize.SMALL, new Double(totalAvailableSpots*0.20).intValue());
        spotCount.put(SpotSize.MEDIUM, new Double(totalAvailableSpots*0.50).intValue());
        spotCount.put(SpotSize.LARGE, new Double(totalAvailableSpots*0.30).intValue());


    }
    public boolean isSpotAvailable(SpotSize spotType) {
        return spotCount.get(spotType)>0;
    }

    public void addVehicle(Vehicle vehicle) {
        SpotSize spotType = getSpotType(vehicle.vehicleType);
        if(spotCount.get(spotType)>0){
            spotCount.put(spotType,spotCount.get(spotType)-1);
        }

        ParkingSpot parkingSpot1= SpotFactory.getParkingSpot(vehicle, spotType);
        parkingSpots.computeIfAbsent(spotType, k -> new ArrayList<>()).add(parkingSpot1);
        /*List<ParkingSpot> parkingSpotList = parkingSpots.get(spotType);
        if(parkingSpotList==null){
            parkingSpotList = new ArrayList<>();

        parkingSpotList.add(parkingSpot1);
        parkingSpots.put(spotType, parkingSpotList);*/
    }
    public SpotSize getSpotType(VehicleType vehicleType){
        switch(vehicleType){
            case VehicleType.CAR: return SpotSize.MEDIUM;
            case VehicleType.MOTORCYCLE : return SpotSize.SMALL;
            case VehicleType.BUS: return SpotSize.LARGE;
            default: return SpotSize.MEDIUM;
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        SpotSize spotType = getSpotType(vehicle.vehicleType);
        spotCount.put(spotType, spotCount.get(spotType)+1);
    }

    public int getTotalAvailableSpots() {
        return spotCount.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isVehiclePresent(Vehicle vehicle) {
        return true;
    }
}
