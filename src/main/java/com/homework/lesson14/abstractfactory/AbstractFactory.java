package com.homework.lesson14.abstractfactory;

public class AbstractFactory {
    private static final String UA_FACTORY = "UA";
    private static final String RU_FACTORY = "RU";

    public static InteAbsFactory getFactory(String country) {

        InteAbsFactory ifactory = null;
        if (country.equals(UA_FACTORY)) {
            ifactory = new UaCarPriceAbsFactory();
        } else if (country.equals(RU_FACTORY)) {
            ifactory = new RuCarPriceAbsFactory();
        }
        return ifactory;
    }
}
