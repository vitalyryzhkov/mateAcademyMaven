package com.homework.lesson14.prototype;

import org.apache.log4j.Logger;

public class MyPrototype {
    private static final Logger LOGGER = Logger.getLogger(MyPrototype.class);

    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = null;
        try {
            clone = prototype.clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error(e.getMessage());
        }
        clone.setType(ComplicatedObject.Type.ONE);
    }
}
