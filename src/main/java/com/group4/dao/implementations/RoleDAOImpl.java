package com.group4.dao.implementations;

import com.group4.dao.interfaces.RoleDAO;
import com.group4.model.Role;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@NoArgsConstructor
public class RoleDAOImpl implements RoleDAO {

    public LocalSessionFactoryBean localSessionFactoryBean;

    private SessionFactory sessionFactory;


    @Autowired
    public RoleDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        this.localSessionFactoryBean = localSessionFactoryBean;
        sessionFactory = localSessionFactoryBean.getObject();
    }

    @Override
    public void create(Role role) {
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
    public void update(Role role) {
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
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findOne() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById() {

    }
}
