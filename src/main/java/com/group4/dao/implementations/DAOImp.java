package com.group4.dao.implementations;

import com.group4.dao.interfaces.DAO;
import com.group4.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;

public class DAOImp<T> implements DAO<T> {
    public LocalSessionFactoryBean localSessionFactoryBean;

    private SessionFactory sessionFactory;


    @Autowired
    public DAOImp(LocalSessionFactoryBean localSessionFactoryBean) {
        this.localSessionFactoryBean = localSessionFactoryBean;
        sessionFactory = localSessionFactoryBean.getObject();
    }

    @Override
    public void create(T role) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error performing JPA operation. Transaction is rolled back");
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T role) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error performing JPA operation. Transaction is rolled back");
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findOne() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById() {

    }
}
