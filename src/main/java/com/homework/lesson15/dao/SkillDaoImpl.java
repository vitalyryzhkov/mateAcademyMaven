package com.homework.lesson15.dao;

import com.homework.lesson15.entities.Skill;
import com.homework.lesson15.interfaces.SkillDao;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
@AllArgsConstructor
public class SkillDaoImpl implements SkillDao<Skill> {
    private EntityManager entityManager;

    @Override
    public boolean createSkill(Skill skill) {
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

    @Override
    public boolean updateSkill(Skill skill) {
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

    @Override
    public Skill readSkill(Long id) {
        try {
            entityManager.getTransaction().begin();
            Skill skill = entityManager.find(Skill.class, id);
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

    @Override
    public boolean deleteSkill(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Skill.class, id));
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
