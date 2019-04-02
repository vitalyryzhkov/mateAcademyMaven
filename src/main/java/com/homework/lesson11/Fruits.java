
package com.homework.lesson11;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fruits {

    private FruitsType type;
    private int shelfLife;
    private LocalDate dateDelivery;
    private int price;
    private Fruits fruits;

    public void setDateDelivery(int year, int month, int day) {
        this.dateDelivery = LocalDate.of(year, month, day);
    }

    public String getDateDelivery() {
        return dateDelivery.toString();
    }
}
