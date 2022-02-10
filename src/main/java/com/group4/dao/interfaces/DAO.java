package com.group4.dao.interfaces;

import com.group4.model.Role;

import java.util.List;

public interface DAO<T> {
    void create(T role);

    void update(T role);

    List<T> findAll();

    T findOne();

    void deleteAll();

    void deleteById();
}
