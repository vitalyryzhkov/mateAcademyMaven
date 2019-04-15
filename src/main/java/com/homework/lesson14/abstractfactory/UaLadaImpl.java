package com.homework.lesson14.abstractfactory;

class UaLadaImpl implements Lada {
    private static final int LADA_PRICE = 1000;

    @Override
    public long getLadaPrice() {
        return LADA_PRICE;
    }
}
