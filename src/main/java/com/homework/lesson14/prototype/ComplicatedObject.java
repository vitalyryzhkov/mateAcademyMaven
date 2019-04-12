package com.homework.lesson14.prototype;

import lombok.Setter;

public class ComplicatedObject implements Copyable {
    @Setter
    private Type type;

    public enum Type {
        ONE, TWO,
    }

    @Override
    public ComplicatedObject copy() {
        return new ComplicatedObject();
    }
}
