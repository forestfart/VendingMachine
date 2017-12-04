package vending.machine;

import java.util.ArrayList;
import java.util.List;

public class TicketsRepository {
    final List<Ticket> ticketOptions = new ArrayList<>();

    public TicketsRepository() {
    }

    public void addTicket(Ticket ticket) {
        ticketOptions.add(ticket);
    }

    public List<Ticket> getTicketOptions() {
        return ticketOptions;
    }
}
