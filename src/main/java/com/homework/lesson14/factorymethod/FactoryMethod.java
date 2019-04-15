package com.homework.lesson14.factorymethod;

public class FactoryMethod {
    public static void main(String[] args){
        String win = "linux";
        Factory factory = new Factory();
        OS os = factory.getCurrentOS(win);
        os.getOS();
    }
}
