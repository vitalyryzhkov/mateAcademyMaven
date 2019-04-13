package com.homework.lesson14.abstractfactory;

class RuPorsheImpl implements Porshe {
    private static final int PORSHE_PRICE = 20000;

    @Override
    public long getPorshePrice() {
        return PORSHE_PRICE;
    }
}
