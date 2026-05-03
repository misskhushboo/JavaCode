package com.assessment.parkinglot;

import com.assessment.parkinglot.enums.SpotSize;
import com.assessment.parkinglot.enums.VehicleType;
import com.assessment.parkinglot.ticket.Ticket;
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
