package vending.machine;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProcessPayment {
    protected boolean paymentAuthorised = false;
    public BigDecimal choicePrice;
    protected BigDecimal cash;
    protected BigDecimal change;

    protected boolean run(Ticket ticketChoice, Scanner keyboard, Language interfaceChoice) {
        interfaceChoice.choosePaymentMethodMessage();
        switch (keyboard.nextInt()) {
            case 1:
                interfaceChoice.insertCashMessage();
                cash = keyboard.nextBigDecimal().setScale(2, BigDecimal.ROUND_HALF_EVEN);
                choicePrice = ticketChoice.getPrice();
                change = cash.subtract(choicePrice).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                if (cash.compareTo(choicePrice) > 0) {
                    interfaceChoice.payOutChange(change);
                    paymentAuthorised = true;
                } else if (cash.compareTo(choicePrice) == 0) {
                    paymentAuthorised = true;
                } else {
                    paymentAuthorised = false;
                }
                break;
            case 2:
                interfaceChoice.payWave();
                choicePrice = ticketChoice.getPrice();
                if (choicePrice.compareTo(BigDecimal.valueOf(50.00)) >= 0) {
                    interfaceChoice.keyInPinMessage();
                    keyboard.nextInt();
                    paymentAuthorised = true;
                } else {
                    paymentAuthorised = true;
                }
                break;
            default:
                paymentAuthorised = false;
        }
        return paymentAuthorised;
    }
}
