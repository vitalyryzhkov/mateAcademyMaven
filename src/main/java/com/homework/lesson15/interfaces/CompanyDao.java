package com.homework.lesson15.interfaces;

public interface CompanyDao<T> {
    boolean createCompany(T t);

    T readCompany(Long id);

    boolean updateCompany(T t);

    boolean deleteCompany(Long id);
}
