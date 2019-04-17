package com.homework.lesson15.dao;

import com.homework.lesson15.entities.Skills;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
@AllArgsConstructor
public class SkillDao {
    private EntityManager entityManager;

    public boolean createSkill(Skills skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(skill);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }

    public boolean updateSkill(Skills skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(skill);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }

    public Skills readSkill(Long id) {
        try {
            entityManager.getTransaction().begin();
            Skills skill = entityManager.find(Skills.class, id);
            entityManager.getTransaction().commit();
            return skill;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return null;
        }
    }

    public boolean deleteSkill(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Skills.class, id));
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }
}
