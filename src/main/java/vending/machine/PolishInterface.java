package vending.machine;

import java.math.BigDecimal;

public class PolishInterface implements Language {

    public void welcomeMessage() {
        System.out.println("Witaj Koleżanko/Kolego!");
    }

    public void displayTicketChoices(TicketsRepository ticketsRepository) {
        System.out.println("Lista dostępnych biletów:");
        ticketsRepository.getTicketOptions().stream().forEach(n -> System.out.println(n.interfacePosition + " - " + n.getNamePl() + "\t cena: " + n.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN) + " zł; "));
    }

    public void choosePaymentMethodMessage() {
        System.out.println("Wybór metody płatności: \n 1 - gotówka; 2 - karta kredytowa");
    }

    public void insertCashMessage() {
        System.out.println("proszę umieścić pieniążki w podajniku (proszę podać kwotę):");
    }

    public void payWave() {
        System.out.println("Proszę zbliżyć kartę do czytnika...");
    }

    public void keyInPinMessage() {
        System.out.print("proszę podać pin: ");
    }

    public void printTicket(Ticket ticketChoice) {
        System.out.println("...drukowanie biletu " + ticketChoice.getNamePl());
    }

    public void payOutChange(BigDecimal change) {
        System.out.println("Proszę zabrać esztę z podajnika, powinno w nim być: " + change.setScale(2,BigDecimal.ROUND_HALF_EVEN) +
                " zł. Jak nie ma to masz wyjątkowego pecha ;)");
    }

    public void backToMainMenu() {
        System.out.println("1 - Kolejny bilet; 0 - Zakończ");
    }

    public void paymentDeclinedMessage() {
        System.out.println("Transakcja odrzucona.. spróbuj ponownie..");
    }

    public void goodByeMessage() {
        System.out.println("Dziękujemy za korzystanie usług MPK \nŻyczymy miłej podróży!");
    }
}
