package com.assessment.parkinglot.ticket;

public class DailyTicket implements TicketStrategy{
    public static final double DAILY_RATE=.10;
    @Override
    public double calculatePrice(Ticket ticket) {
        return  ((ticket.getEntryTime()-ticket.getExitTime())/86400)*DAILY_RATE;
    }
}