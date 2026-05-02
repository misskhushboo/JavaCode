package com.assessment.parkinglot;

public enum VehicleType {
    MOTORCYCLE("MOTORCYCLE"),

    CAR("CAR"),

    BUS("BUS");
    String vehicleType;

     VehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }
}
