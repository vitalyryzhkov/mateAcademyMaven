package com.homework.lesson14.abstractfactory;

public class AbstractFactory {
    public static InteAbsFactory getFactory(String country) {
        InteAbsFactory ifactory = null;
        if (country.equals("UA")) {
            ifactory = new UaCarPriceAbsFactory();
        } else if (country.equals("RU")) {
            ifactory = new RuCarPriceAbsFactory();
        }
        return ifactory;
    }
}
