package com.group4.dao.interfaces;

import java.util.List;

public interface DAO<T> {
    void save(T entity);

    void update(T entity);

    List<T> findAll(Class clazz);

    Object findById(int id, Class clazz);

    void deleteAll();

    void deleteById(int id, Class clazz);
}
