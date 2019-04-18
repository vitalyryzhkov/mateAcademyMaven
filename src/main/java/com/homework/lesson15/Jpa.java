package com.homework.lesson15;

import com.homework.lesson15.dao.DeveloperDaoImpl;
import com.homework.lesson15.entities.Developer;
import com.homework.lesson15.entities.SexType;
import com.homework.lesson15.services.HibernateUtil;

import javax.persistence.EntityManager;

public class Jpa {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        Developer developer = Developer.builder()
                .name("Davi")
                .age(19)
                .sex(SexType.FEMALE)
                .build();

        DeveloperDaoImpl developerDao = new DeveloperDaoImpl(entityManager);
        developerDao.createDeveloper(developer);
        HibernateUtil.close();

    }
}
