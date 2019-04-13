package com.homework.lesson14.abstractfactory;

class RuLadaImpl implements Lada {
    private static final int LADA_PRICE = 10000;

    @Override
    public long getLadaPrice() {
        return LADA_PRICE;
    }
}
