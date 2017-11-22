package vending.machine;

import java.math.BigDecimal;

public interface Language {
    void welcomeMessage();
    void displayTicketChoices(TicketsRepository ticketsRepository);
    void choosePaymentMethodMessage();
    void insertCashMessage();
    void payWave();
    void keyInPinMessage();
    void paymentDeclinedMessage();
    void printTicket(Ticket ticketChoice);
    void payOutChange(BigDecimal change);
    void backToMainMenu();
    void goodByeMessage();
}
