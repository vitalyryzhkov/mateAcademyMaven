package com.homework.lesson15.interfaces;

public interface ProjectDao<T> {
    boolean createProject(T t);

    T readProject(Long id);

    boolean updateProject(T t);

    boolean deleteProject(Long id);
}
