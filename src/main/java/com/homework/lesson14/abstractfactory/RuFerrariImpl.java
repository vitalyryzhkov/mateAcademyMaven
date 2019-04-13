package com.homework.lesson14.abstractfactory;

class RuFerrariImpl implements Ferrari {
    private static final int FERRARI_PRICE = 30000;

    @Override
    public long getFerrariPrice() {
        return FERRARI_PRICE;
    }
}
