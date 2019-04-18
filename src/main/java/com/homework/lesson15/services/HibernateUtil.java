package com.homework.lesson15.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class HibernateUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    private HibernateUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void close() {
        if (factory != null) {
            factory.close();
        }
    }
}
