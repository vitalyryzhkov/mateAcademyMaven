package com.homework.lesson15.interfaces;

public interface SkillDao<T> {
    boolean createSkill(T t);

    T readSkill(Long id);

    boolean updateSkill(T t);

    boolean deleteSkill(Long id);
}
