package vending.machine;

import java.util.Scanner;

public class VendingMachine {
    private Language interfaceChoice;
    private Ticket ticketChoice = null;
    private ProcessPayment processPayment;

    public VendingMachine() {
    }

    public Language languageChoice(Scanner keyboard) {

        System.out.println("Wybierz język / Select language: \n 1 - polski; 2 - english \n 0 - koniec / exit");

        switch (keyboard.nextInt()) {
            case 0:
                return null; //EXIT
            case 1:
                return new PolishInterface();
            case 2:
                return new EnglishInterface();
            default:
                return new PolishInterface();
        }
    }

    public void run(Scanner keyboard, TicketsRepository ticketsRepository) {
        boolean exit = false;
        processPayment = null;

        while (!exit) {
            interfaceChoice = languageChoice(keyboard);
            if (interfaceChoice != null) {

                interfaceChoice.welcomeMessage();

                interfaceChoice.displayTicketChoices(ticketsRepository);

                int ticketNumber = keyboard.nextInt();

                if (ticketNumber > 1 && ticketNumber < ticketsRepository.getTicketOptions().size() + 1) {

                    ticketChoice = ticketsRepository.getTicketOptions().get(ticketNumber - 1);
                    processPayment = new ProcessPayment();

                    if (processPayment.run(ticketChoice, keyboard, interfaceChoice)) {
                        interfaceChoice.printTicket(ticketChoice);
                        interfaceChoice.backToMainMenu();

                        if (keyboard.nextInt() == 0) {
                            exit = true;
                            interfaceChoice.goodByeMessage();
                        }

                    } else {
                        interfaceChoice.paymentDeclinedMessage();
                    }

                } else {
                    interfaceChoice.backToMainMenu();
                }

            } else {
                exit = true;
                interfaceChoice = new  PolishInterface();
                interfaceChoice.goodByeMessage();
            }
        }
    }
}
