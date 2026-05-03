package com.parkinglot;

import com.parkinglot.enums.TicketType;
import com.parkinglot.ticket.Ticket;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Singleton class to create ParkingLot with given levels and spots
 * @author khushboo.kaur
 * @version 1.0
 */
public class ParkingLot {

    int totalParkingLevels;
    private static Map<Integer, ParkingLevel> levels;
    private static ParkingLot parkinglot;

    private ParkingLot(int parkingLevels, int spotPerLevel){
        this.totalParkingLevels = parkingLevels;
        levels= new HashMap<>();
    }
    public static synchronized ParkingLot setupParkingLot(int parkingLevels, int spotPerLevel){
        if(parkinglot==null) parkinglot= new ParkingLot(parkingLevels, spotPerLevel);
        levels.putIfAbsent(1, new ParkingLevel(100));
        return parkinglot;
    }

    public void addVehicle(Vehicle vehicle){
        ParkingLevel availableLevel=levels.values().stream()
                .filter( parkingLevel -> parkingLevel.getTotalAvailableSpots()>0)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Parking lot is full"));
        availableLevel.addVehicle(vehicle);
        Ticket ticket=Ticket.getInstance(vehicle, TicketType.DailyTicket);
        vehicle.setTicket(ticket);
    }

    public void exitVehicle(Vehicle vehicle){
        Optional<ParkingLevel> level= levels.values().stream()
                .filter(parkingLevel -> parkingLevel.isVehiclePresent(vehicle))
                .findFirst();
        if(level.isPresent()){
            level.get().removeVehicle(vehicle);
            vehicle.getTicket().setExitTime(LocalDateTime.now().toLocalTime().toSecondOfDay());
            vehicle.getTicket().endTicket(vehicle.getTicket().getTicketStrategy());
        }
    }
}
