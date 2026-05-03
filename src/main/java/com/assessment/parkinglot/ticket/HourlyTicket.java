package com.assessment.parkinglot.ticket;

public class HourlyTicket implements TicketStrategy{
public static final double HOURLY_RATE=.20;
    @Override
    public double calculatePrice(Ticket ticket) {
        return  ((ticket.getEntryTime()-ticket.getExitTime())/3600)*HOURLY_RATE;
    }
}
