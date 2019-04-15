package com.homework.lesson14.abstractfactory;

class UaPorsheImpl implements Porshe {
    private static final int PORSHE_PRICE = 2000;

    @Override
    public long getPorshePrice() {
        return PORSHE_PRICE;
    }
}
