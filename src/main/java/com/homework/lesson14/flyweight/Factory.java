package com.homework.lesson14.flyweight;

public class Factory {
    private Flyweight[] pool;

    public Factory(int maxRows) {
        if (maxRows >= 0) {
            pool = new Flyweight[maxRows];
        }
    }

    public Flyweight getFlyweight(int row) {
        if (row >= 0) {
            if (pool[row] == null) {
                pool[row] = new Flyweight(row);
            }
        }
        return pool[row];
    }
}
