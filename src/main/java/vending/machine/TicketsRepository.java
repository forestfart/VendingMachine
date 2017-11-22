package vending.machine;

import java.util.ArrayList;

public class TicketsRepository {
    final ArrayList<Ticket> ticketOptions = new ArrayList<>();

    public TicketsRepository() {
    }

    public void addTicket(Ticket ticket) {
        ticketOptions.add(ticket);
    }

    public ArrayList<Ticket> getTicketOptions() {
        return ticketOptions;
    }
}
