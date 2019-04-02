
package com.homework.lesson11pr;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FruitsType {
    APPLE(10),
    MANGO(10),
    STRAWBERRY(10),
    AVOCADO(10),
    BANANA(10),
    PEAR(10),
    PINEAPPLE(10),
    CHERRY(10),
    PLUM(10),
    BLUEBERRY(10),
    ;

    private int shelfLifeDays;
}
