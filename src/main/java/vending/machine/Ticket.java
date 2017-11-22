package vending.machine;

import java.math.BigDecimal;

public class Ticket {
    final int interfacePosition;
    final String namePl;
    final String nameEn;
    final BigDecimal price;

    public Ticket(int interfacePosition, String namePl, String nameEn, BigDecimal price) {
        this.interfacePosition = interfacePosition;
        this.namePl = namePl;
        this.nameEn = nameEn;
        this.price = price;
    }

    public String getNamePl() {
        return namePl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public BigDecimal getPrice() {
        return price;
    }
}