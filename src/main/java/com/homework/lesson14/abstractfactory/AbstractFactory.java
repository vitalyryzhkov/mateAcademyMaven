package com.homework.lesson14.abstractfactory;

public class AbstractFactory {
    private static final String uaFactory = "UA";
    private static final String ruFactory = "RU";

    public static InteAbsFactory getFactory(String country) {

        InteAbsFactory ifactory = null;
        if (country.equals(uaFactory)) {
            ifactory = new UaCarPriceAbsFactory();
        } else if (country.equals(ruFactory)) {
            ifactory = new RuCarPriceAbsFactory();
        }
        return ifactory;
    }
}
