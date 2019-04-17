package com.homework.lesson15.dao;

import com.homework.lesson15.entities.Customers;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class CustomerDao {
    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean createCustomer(Customers customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
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

    public boolean updateCustomer(Customers customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
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

    public Customers readCustomer(Long id) {
        try {
            entityManager.getTransaction().begin();
            Customers customer = entityManager.find(Customers.class, id);
            entityManager.getTransaction().commit();
            return customer;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return null;
        }
    }

    public boolean deleteCustomer(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Customers.class, id));
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
