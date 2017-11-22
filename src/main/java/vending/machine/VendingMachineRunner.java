package vending.machine;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineRunner {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        TicketsRepository ticketsRepository = new TicketsRepository();

        ticketsRepository.addTicket(new Ticket(1,"Zwykły 20-minutowy","SingleRegular 40min", BigDecimal.valueOf(2.00)));
        ticketsRepository.addTicket(new Ticket(2,"Studencki 20-minut","StudentSaver 40min", BigDecimal.valueOf(1.40)));
        ticketsRepository.addTicket(new Ticket(3,"Zwykły 40-minutowy","SingleRegular 20min", BigDecimal.valueOf(2.80)));
        ticketsRepository.addTicket(new Ticket(4,"Studencki 40-minut","StudentSaver 20min", BigDecimal.valueOf(2.00)));
        ticketsRepository.addTicket(new Ticket(5,"Zwykły Całodniowy","Single\tDaySaver", BigDecimal.valueOf(10.00)));
        ticketsRepository.addTicket(new Ticket(6,"Studencki Całodniowy","Student\tDaySaver", BigDecimal.valueOf(8.90)));
        ticketsRepository.addTicket(new Ticket(7,"Zwykły Tygodniowy","Single\tWeekSaver", BigDecimal.valueOf(29.00)));
        ticketsRepository.addTicket(new Ticket(8,"Studencki Tygodniowy","Student\tWeekSaver", BigDecimal.valueOf(22.90)));
        ticketsRepository.addTicket(new Ticket(9,"Miesięczny DusiGrosz","MonthlySuperSaver", BigDecimal.valueOf(52.00)));
        ticketsRepository.addTicket(new Ticket(10,"Kwartalny Super!","QuarterlyMegaSaver", BigDecimal.valueOf(130.50)));

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.run(keyboard, ticketsRepository);
    }
}
