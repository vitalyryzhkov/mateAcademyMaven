package com.homework.lesson15.interfaces;

public interface DeveloperDao<T> {
    boolean createDeveloper(T t);

    T readDeveloper(Long id);

    boolean updateDeveloper(T t);

    boolean deleteDeveloper(Long id);
}
