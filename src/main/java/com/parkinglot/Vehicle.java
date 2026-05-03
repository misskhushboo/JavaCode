package com.parkinglot;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.ticket.Ticket;
import lombok.Data;

@Data
public class Vehicle {

    String licensePlateNumber;
    VehicleType vehicleType;
    Ticket ticket;
    public Vehicle(String licensePlateNumber, VehicleType vehicleType) {
        this.licensePlateNumber = licensePlateNumber;
        this.vehicleType = vehicleType;
    }


}
