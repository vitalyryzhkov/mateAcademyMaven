package com.homework.lesson14.abstractfactory;

class UaFerrariImpl implements Ferrari {
    private static final int FERRARI_PRICE = 3000;

    @Override
    public long getFerrariPrice() {
        return FERRARI_PRICE;
    }
}
