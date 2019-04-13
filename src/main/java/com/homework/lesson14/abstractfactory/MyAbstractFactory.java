package com.homework.lesson14.abstractfactory;

public class MyAbstractFactory {
    public static void main(String[] args) {
        InteAbsFactory ifactory = AbstractFactory.getFactory("UA");
        Lada lada = ifactory.getLada();
        System.out.println(lada.getLadaPrice());
    }
}
