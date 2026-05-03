package com.assessment.parkinglot.ticket;

import com.assessment.parkinglot.Vehicle;
import com.assessment.parkinglot.enums.TicketType;
import com.assessment.parkinglot.spots.ParkingSpot;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    private final Vehicle vehicle;
    private final int entryTime;
    private int exitTime;
    private ParkingSpot parkingspot;
    private final TicketStrategy ticketStrategy;

    public static Ticket getInstance(Vehicle vehicle, TicketType ticketType){

        return new Ticket(vehicle, getTicketStrategy(ticketType));
    }
    public Ticket(Vehicle vehicle, TicketStrategy ticketStrategy){
        this.vehicle=vehicle;
        entryTime= LocalDateTime.now().getSecond();
        this.ticketStrategy=ticketStrategy;
    }

    public double endTicket(TicketStrategy ticketStrategy){
        return ticketStrategy.calculatePrice(this);
    }

    private static TicketStrategy getTicketStrategy(TicketType ticketType){
        switch (ticketType){
            case DailyTicket: return new DailyTicket();
            case HourlyTicket: return new HourlyTicket();
            default: throw new RuntimeException("Invalid ticket type");
        }
    }
}
