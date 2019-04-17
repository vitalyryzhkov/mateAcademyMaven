package com.homework.lesson15;

import com.homework.lesson15.dao.DeveloperDao;
import com.homework.lesson15.entities.Developers;
import com.homework.lesson15.services.HibernateUtil;

import javax.persistence.EntityManager;

public class JpaUtil {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        Developers developers = Developers.builder()
                .name("Davi")
                .age(19)
                .sex("female")
                .build();

        DeveloperDao developerDao = new DeveloperDao(entityManager);
        developerDao.createDeveloper(developers);
        HibernateUtil.close();

    }
}
