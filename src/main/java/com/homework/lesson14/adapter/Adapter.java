package com.homework.lesson14.adapter;

public class Adapter {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        IphoneAdapter samsung = new IphoneAdapter(new Samsung());
        System.out.println(iphone + "\n"
                + "Samsung price = " + samsung.getPrice());
    }
}
