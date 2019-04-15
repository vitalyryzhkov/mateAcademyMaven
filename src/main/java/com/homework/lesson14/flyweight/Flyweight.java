package com.homework.lesson14.flyweight;

public class Flyweight {
    private int row;

    public Flyweight(int row) {
        this.row = row;
        System.out.println("step: " + this.row);
    }

    void report(int col) {
        System.out.print(" " + row + col);
    }
}
