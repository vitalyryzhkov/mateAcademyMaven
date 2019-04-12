package com.homework.lesson14.adapter;

public class Adapter {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.getPrice();
        IphoneAdapter samsung = new IphoneAdapter(new Samsung());
        samsung.getPrice();
    }
}
