package com.assessment.parkinglot;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ParkingLevel {
    int totalAvailableSpots;
    Map<SpotSize, Integer> spotCount;

    public ParkingLevel(int totalSpots, Map<SpotSize, Integer> spotCount) {
        this.totalAvailableSpots = totalSpots;
        this.spotCount = spotCount;
    }
    public Integer getSpotCount(SpotSize spotType) {
        return spotCount.get(spotType);
    }
    public void initializeLevel(int totalAvailableSpots){
        this.totalAvailableSpots = totalAvailableSpots;
        spotCount=new ConcurrentHashMap<>(SpotSize.values().length);
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
    }
    public SpotSize getSpotType(Enum vehicleType){
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
}
