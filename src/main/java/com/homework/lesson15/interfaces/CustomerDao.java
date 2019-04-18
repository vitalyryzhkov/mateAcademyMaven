package com.homework.lesson15.interfaces;

public interface CustomerDao<T> {
    boolean createCustomer(T t);

    T readCustomer(Long id);

    boolean updateCustomer(T t);

    boolean deleteCustomer(Long id);
}
