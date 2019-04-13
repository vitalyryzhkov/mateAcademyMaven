package com.homework.lesson14.adapter;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Iphone {
    private final int PRICE = 100;

    @Override
    public String toString() {
        return "Iphone price = " + PRICE;
    }
}
