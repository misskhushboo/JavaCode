package com.parkinglot.spots;

import com.parkinglot.enums.SpotSize;
import com.parkinglot.Vehicle;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class ParkingSpot {

    String parkingSpotId;
    boolean isAvailable;
    Vehicle vehicleParked;
    SpotSize spotSize;

    public ParkingSpot(Vehicle vehicle,SpotSize spotSize) {
        this.parkingSpotId = UUID.randomUUID().toString();
        this.vehicleParked = vehicle;
        this.spotSize = spotSize;
        this.isAvailable = false;
    }

    public void removeVehicle(){
        this.vehicleParked = null;
        this.isAvailable = true;
    }

}
