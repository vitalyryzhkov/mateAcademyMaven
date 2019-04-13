package com.homework.lesson14.prototype;

import java.util.Objects;

public class MyPrototype {
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = null;
        try {
            clone = prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(clone).setType(ComplicatedObject.Type.ONE);
    }
}
