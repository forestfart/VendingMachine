package vending.machine;

import java.util.Scanner;

public class VendingMachine extends Exception {
    private Language interfaceChoice;
    private Ticket ticketChoice = null;

    public VendingMachine() {
    }

    public Language languageChoice(Scanner keyboard) /*throws NullPointerException */{

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
        while (exit == false) {
            interfaceChoice = languageChoice(keyboard);
            if (interfaceChoice != null) {

                interfaceChoice.welcomeMessage();

                interfaceChoice.displayTicketChoices(ticketsRepository);

                ticketChoice = ticketsRepository.getTicketOptions().get(keyboard.nextInt() - 1);

                ProcessPayment processPayment = new ProcessPayment();

                if (processPayment.run(ticketChoice, keyboard, interfaceChoice) == true) {
                    interfaceChoice.printTicket(ticketChoice);
                    interfaceChoice.backToMainMenu();
                    if(keyboard.nextInt() == 0) {
                        exit = true;
                        interfaceChoice.goodByeMessage();
                    }
                } else {
                    interfaceChoice.paymentDeclinedMessage();
                }

            } else {
                exit = true;
                interfaceChoice.goodByeMessage();
            }
        }
    }
}
