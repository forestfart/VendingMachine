package vending.machine;

import java.math.BigDecimal;

public class EnglishInterface implements Language {
    public void welcomeMessage() {
        System.out.println("Hello there!");
    }

    public void displayTicketChoices(TicketsRepository ticketsRepository) {
        System.out.println("Available tickets:");
        ticketsRepository.getTicketOptions().stream().forEach(n -> System.out.println(n.interfacePosition + " - " + n.getNameEn() + "\t price: " + n.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN) + " zl; "));
    }

    public void choosePaymentMethodMessage() {
        System.out.println("Choose payment method: \n 1 - cash; 2 - credit card");
    }

    public void insertCashMessage() {
        System.out.println("please insert cash (just type in ammount):");
    }

    public void payWave() {
        System.out.println("Please use payWave...");
    }

    public void keyInPinMessage() {
        System.out.print("Enter Pin number: ");
    }

    public void printTicket(Ticket ticketChoice) {
        System.out.println("...printing out the ticket " + ticketChoice.getNameEn());
    }

    public void payOutChange(BigDecimal change) {
        System.out.println("Please take your change, you should find: " + change.setScale(2,BigDecimal.ROUND_HALF_EVEN) +
                " zl. If not, you got no luck today ;)");
    }

    public void backToMainMenu() {
        System.out.println("1 - Another ticket; 0 - Exit");
    }

    public void paymentDeclinedMessage() {
        System.out.println("Payment declined.. please try again later..");
    }

    public void goodByeMessage() {
        System.out.println("Thank you for choosing MPK \nHave a pleasant journey!");
    }
}