package com.group4.dao.interfaces;

import java.util.List;

public interface DAO<T> {
    void save(T role);

    void update(T role);

    List<T> findAll();

    T findById(int id);

    void deleteAll();

    void deleteById(int id);
}
