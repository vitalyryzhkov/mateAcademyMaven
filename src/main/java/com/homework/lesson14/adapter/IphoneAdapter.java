package com.homework.lesson14.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IphoneAdapter extends Iphone {
    private Samsung samsung;

        public int getPrice() {
        return samsung.getPRICE();
    }
}
