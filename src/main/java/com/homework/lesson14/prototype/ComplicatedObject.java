package com.homework.lesson14.prototype;

import lombok.Setter;

public class ComplicatedObject implements Cloneable {
    @Setter
    private Type type;

    public enum Type {
        ONE, TWO,
    }

    public ComplicatedObject clone() throws CloneNotSupportedException {
//    @Override
//    public ComplicatedObject copy() {
        return (ComplicatedObject) super.clone();
    }
}
